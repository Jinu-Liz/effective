package practice.effective.chapter_04.item_33.super_type_token;

import java.util.ArrayList;
import java.util.List;

public class Oops {

  static Favorites f = new Favorites();

  static <T> List<T> favoriteList() {
    TypeRef<List<T>> ref = new TypeRef<>() {};
    System.out.println(ref.getType());

    List<T> result = f.get(ref);
    if (result == null) {
      result = new ArrayList<T>();
      f.put(ref, result);
    }

    return result;
  }

  /**
   * 각각 따로 꺼낼 것 같지만, 둘 다 타입이 List<T> 이다.
   *
   * List<String>에 의해 ArrayList<String>이 생성된다.
   * 그 후 List<Integer>에서 Key가 List<T>로 같으므로, ArrayList<String>가 반환된다.
   * 여기에 1을 넣은 후, String으로 꺼내려고 하니 에러가 발생한다.
   *
   * 그러나 컴파일 에러가 발생하지 않아 정상적인 코드처럼 보인다.
   */
  public static void main(String[] args) {
    List<String> ls = favoriteList();

    List<Integer> li = favoriteList();
    li.add(1);

    for (String s : ls) System.out.println(s);
  }
}
