package practice.effective.chapter_04.item_28.safevarargs;

import java.util.List;

public class SafeVarargsExample {

  /**
   * 매개변수로 받은 배열이 오염될 가능성이 있다.
   * 원래 제네릭 타입과 배열은 함께 사용할 수 없으나, 매개변수에서는 가능하다.
   *
   * @SafeVarargs 를 선언한다고해서 문제가 해결되지 않는다.
   */
  @SafeVarargs
  static void notSafe(List<String>... stringLists) {
    Object[] array = stringLists;   // List<String> ... => List[]과 같다. 배열은 공변이고, Object를 상속받기 때문에 Object[]로 선언 가능.
    List<Integer> tmpList = List.of(42);
    array[0] = tmpList;
    String s = stringLists[0].get(0);   // Integer를 String으로 선언하려 하므로 ClassCastException
  }

  /**
   * 경고를 무시하기 위한 어노테이션.
   */
  @SafeVarargs
  static <T> void safe(T... values) {
    for (T value : values) {
      System.out.println(value);
    }
  }

  public static void main(String[] args) {
    SafeVarargsExample.safe("a", "b", "c");
    SafeVarargsExample.notSafe(List.of("a", "b", "c"));
  }
}
