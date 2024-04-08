package practice.effective.chapter_04.item_33.super_type_token;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Favorites {

  private Map<TypeRef<?>, Object> favorites = new HashMap<>();

  public <T> void put(TypeRef<T> typeRef, T value) {
    this.favorites.put(typeRef, value);
  }

  @SuppressWarnings("unchecked")
  public <T> T get(TypeRef<T> typeRef) {
    return (T) this.favorites.get(typeRef);
  }

  /**
   * equals, hashcode에서 다르다고 판단하기 때문에
   * List<타입>에 따라 Key로 사용할 수 있게 된다.
   */
  public static void main(String[] args) {
    Favorites favorites = new Favorites();
    favorites.put(new TypeRef<List<String>>() {}, List.of("a", "b", "c"));
    favorites.put(new TypeRef<List<Integer>>() {}, List.of(1, 2, 3));
    favorites.get(new TypeRef<List<String>>() {}).forEach(System.out::println);
    favorites.get(new TypeRef<List<Integer>>() {}).forEach(System.out::println);
  }

}
