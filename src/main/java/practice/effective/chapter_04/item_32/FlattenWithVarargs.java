package practice.effective.chapter_04.item_32;

import java.util.ArrayList;
import java.util.List;

// 제네릭 varargs 매개변수를 안전하게 사용하는 메서드
public class FlattenWithVarargs {

  /**
   * 가변인자 내에 값을 넣지 않고 꺼내 쓰기만하면 안전.
   */
  @SafeVarargs
  static <T> List<T> flatten(List<? extends T>... lists) {
    List<T> result = new ArrayList<>();
    for (List<? extends T> list : lists) {
      result.addAll(list);
    }

    return result;
  }

  public static void main(String[] args) {
    List<Integer> flatList = flatten(
      List.of(1, 2),
      List.of(3, 4, 5),
      List.of(6, 7)
    );

    System.out.println(flatList);
  }
}
