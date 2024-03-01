package practice.effective.chapter_01.item_07.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class AfterPostRepository {

  private Map<CacheKey, Post> cache;

  public AfterPostRepository() {
    this.cache = new WeakHashMap<>();
  }

  public Post getPostById(CacheKey key) {
    if (this.cache.containsKey(key)) {

      return this.cache.get(key);
    } else {
      // TODO DB에서 읽어오거나 REST API를 통해 읽어올 수 있습니다.
      Post post = new Post();
      this.cache.put(key, post);

      return post;
    }
  }

  public Map<CacheKey, Post> getCache() {
    return this.cache;
  }
}
