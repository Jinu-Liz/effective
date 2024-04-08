package practice.effective.chapter_04.item_33.type_token;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 타입 안전 이종 컨테이너
 */
public class FavoritesMapAfter {

  private Map<Class<?>, Object> map = new HashMap<>();

  /**
   * client에서 악의적으로 raw타입으로 넘기는 것은 컴파일 단계에서 막을수는 없지만,
   * 예시) favorites.put((Class) String.class, 1);
   * clazz.cast로 체크하면 좀 더 빠르게 확인할 수 있다.
   */
  public <T> void put(Class<T> clazz, T value) {
    this.map.put(Objects.requireNonNull(clazz), clazz.cast(value));
  }

  public <T> Object get2(Class<T> clazz) {
    return this.map.get(clazz);
  }

  /**
   * 타입이 안전한지 확인해서 사용하면
   * @SuppressWarnings 를 사용하지 않아도 경고가 발생하지 않는다.
   */
  public <T> T get(Class<T> clazz) {
    return clazz.cast(this.map.get(clazz));
  }

  /**
   * 선언한 타입과 다른 경우, 컴파일 에러가 발생한다.
   */
  public static void main(String[] args) {
    FavoritesMapAfter favorites = new FavoritesMapAfter();
//    favorites.put(String.class, 1);
    favorites.put(String.class, "jinuliz");
//    favorites.put(Integer.class, "jinuliz");
    favorites.put(Integer.class, 2);

    String s = favorites.get(String.class);
    Integer integer = favorites.get(Integer.class);

    /**
     * List타입의 경우, List<Integer>.class 이런 식으로 사용할 수 없으므로
     * 아래의 Integer와 String List를 구분할 수 없다.
     */
    favorites.put(List.class, List.of(1, 2, 3));
    favorites.put(List.class, List.of("a", "b", "c"));
    List list = favorites.get(List.class);
    list.forEach(System.out::println);
  }

}
