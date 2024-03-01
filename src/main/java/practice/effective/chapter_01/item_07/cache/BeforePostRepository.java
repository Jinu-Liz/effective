package practice.effective.chapter_01.item_07.cache;

import java.util.HashMap;
import java.util.Map;

public class BeforePostRepository {

  private Map<CacheKey, Post> cache;

  public BeforePostRepository() {
    this.cache = new HashMap<>();
  }

  public Post getPostById(Integer id) {
    CacheKey key = new CacheKey(id);
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
