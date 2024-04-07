package practice.effective.chapter_04.item_32;

import java.util.List;

/**
 * 제네릭 varargs 배열 매개변수에 값을 저장하는 것은 안전하지 않다.
 */
public class Dangerous {

  /**
   * 제네릭과 varargs를 혼용하면 타입 안전성이 깨진다.
   * 컴파일 타임에 확인이 안된다.
   */
  static void dangerous(List<String>... stringLists) {
    List<Integer> intList = List.of(42);
    Object[] objects = stringLists;
    objects[0] = intList;   // 힙 오염 발생
    String s = stringLists[0].get(0);   // ClassCastException
  }

  public static void main(String[] args) {
    dangerous(List.of("There be dragons!"));
  }
}
