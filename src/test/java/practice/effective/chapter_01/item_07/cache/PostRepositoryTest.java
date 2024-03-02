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
    p1 = null;

    Assertions.assertFalse(postRepository.getCache().isEmpty());

    // TODO run gc
    System.out.println("run gc");
    System.gc();
    System.out.println("wait");
    Thread.sleep(3000L);

    assertTrue(postRepository.getCache().isEmpty());
  }

  /**
   * Integer나 String 등의 경우, JVM 내부에 상수풀 같은 것으로 이미 캐싱이 되어있다.
   * 때문에 null을 할당해도 GC의 대상이 되지 않는다.
   * 그렇기에 Key 객체를 별도로 만들어 사용해야 한다.
   */
  @Test
  void weakCache() throws InterruptedException {
    AfterPostRepository postRepository = new AfterPostRepository();
    CacheKey key = new CacheKey(1);
    Post postById = postRepository.getPostById(key);
    key = null;

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