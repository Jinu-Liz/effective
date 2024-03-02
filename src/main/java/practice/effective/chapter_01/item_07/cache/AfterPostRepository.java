package practice.effective.chapter_01.item_07.cache;

import java.util.Map;
import java.util.WeakHashMap;

public class AfterPostRepository {

  private Map<CacheKey, Post> cache;

  /**
   * 보통 Map을 쓰는 경우는 Value가 더 중요하기 때문에
   * Value가 참조되는 한 Key를 남겨놓는다.
   * 그러나 간혹 Key가 참조 되지 않는 경우, Value 또한 무의미해지는 경우가 있다.
   * WeakHashMap은 그런 경우에 사용한다.
   */
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
