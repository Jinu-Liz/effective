package practice.effective.chapter_01.item_07.cache;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class PostRepositoryTest {

  @Test
  void cache() throws InterruptedException {
    BeforePostRepository postRepository = new BeforePostRepository();
    Integer p1 = 1;
    Post postById = postRepository.getPostById(p1);

    Assertions.assertFalse(postRepository.getCache().isEmpty());

    // TODO run gc
    System.out.println("run gc");
    System.gc();
    System.out.println("wait");
    Thread.sleep(3000L);

    assertTrue(postRepository.getCache().isEmpty());
  }

  @Test
  void weakCache() throws InterruptedException {
    AfterPostRepository postRepository = new AfterPostRepository();
    CacheKey key = new CacheKey(1);
    Post postById = postRepository.getPostById(key);

    Assertions.assertFalse(postRepository.getCache().isEmpty());

    // TODO run gc
    System.out.println("run gc");
    System.gc();
    System.out.println("wait");
    Thread.sleep(3000L);

    assertTrue(postRepository.getCache().isEmpty());
  }

  /**
   * 백그라운드에서 캐시 삭제 로직
   */
  @Test
  void backgroundThread() throws InterruptedException {
    ScheduledExecutorService excutor = Executors.newScheduledThreadPool(1);
    AfterPostRepository postRepository = new AfterPostRepository();
    CacheKey key = new CacheKey(1);
    postRepository.getPostById(key);

    Runnable removeOldCache = () -> {
      System.out.println("running removeOldCache task");
      Map<CacheKey, Post> cache = postRepository.getCache();
      Set<CacheKey> cacheKeys = cache.keySet();
      Optional<CacheKey> key1 = cacheKeys.stream().min(Comparator.comparing(CacheKey::getCreated));
      key1.ifPresent((k) -> {
        System.out.println("removing " + k);
        cache.remove(k);
      });
    };

    System.out.println("The time is : " + new Date());

    excutor.scheduleAtFixedRate(removeOldCache, 1, 3, TimeUnit.SECONDS);

    Thread.sleep(20000L);

    excutor.shutdown();
  }
}