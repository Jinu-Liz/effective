package practice.effective.chapter_04.item_32;

import java.util.ArrayList;
import java.util.List;

// 제네릭 varargs 매개변수를 안전하게 사용하는 메서드
public class FlattenWithList {

  /**
   * 제네릭 varargs 매개변수를 List로 대체
   * 해당 타입을 상속받는 타입들 모두 허용
   */
  static <T> List<T> flatten(List<List<? extends T>> lists) {
    List<T> result = new ArrayList<>();
    for (List<? extends T> list : lists) {
      result.addAll(list);
    }

    return result;
  }

  public static void main(String[] args) {
    List<Number> flatList = flatten(List.of(
      List.of(1, 2),
      List.of(3.0, 4.0, 5.2),
      List.of(6, 7))
    );

    System.out.println(flatList);
  }
}
