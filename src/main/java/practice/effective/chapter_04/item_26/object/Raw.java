package practice.effective.chapter_04.item_26.object;

import java.util.ArrayList;
import java.util.List;

// 런타임에 실패한다.
public class Raw {
  public static void main(String[] args) {
    List<String> string = new ArrayList<>();
    unsafeAdd(string, Integer.valueOf(42));
    String s = string.get(0);   // 컴파일러가 자동으로 형변환 코드를 넣어준다.
  }

  /**
   * list에 넣을 때는 에러가 나지 않다가, 꺼낼 때 에러가 난다.
   */
  private static void unsafeAdd(List list, Object o) {
    list.add(o);
  }
}
