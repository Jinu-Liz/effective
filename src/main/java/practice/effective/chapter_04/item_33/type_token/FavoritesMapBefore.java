package practice.effective.chapter_04.item_33.type_token;

import java.util.HashMap;
import java.util.Map;

public class FavoritesMapBefore<T> {

  private Map<Class, Object> map = new HashMap<>();

  public void put(Class clazz, Object value) {
    this.map.put(clazz, value);
  }

  public Object get(Class clazz) {
    return this.map.get(clazz);
  }

  /**
   * String임에도 1이라는 Integer값이 들어가고,
   * Integer임에도 "jinuliz"라는 String값이 들어간다.
   */
  public static void main(String[] args) {
    FavoritesMapBefore favorites = new FavoritesMapBefore();
    favorites.put(String.class, 1);
    favorites.put(String.class, "jinuliz");
    favorites.put(Integer.class, "jinuliz");
    favorites.put(Integer.class, 2);

  }

}
