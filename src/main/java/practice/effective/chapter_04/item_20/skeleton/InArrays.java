package practice.effective.chapter_04.item_20.skeleton;

import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * 골격 구현을 사용해 완성한 구체 클래스
 */
public class InArrays {
  static List<Integer> intArrayAsList(int[] a) {
    Objects.requireNonNull(a);

    /**
     * 인터페이스인 List를 생성하려고 하면
     * 수많은 메서드를 구현해야하지만,
     * AbstractList는 몇 개만 구현하면 된다.
     */
    return new AbstractList<>() {
      @Override
      public Integer get(int index) {
        return a[index];
      }

      @Override
      public Integer set(int index, Integer element) {
        int oldVal = a[index];  // 오토 언박싱
        a[index] = element;   // 오토 박싱

        return oldVal;
      }

      @Override
      public int size() {
        return a.length;
      }
    };
  }

  public static void main(String[] args) {
    int[] a = new int[10];
    for (int i = 0; i < a.length; i++) {
      a[i] = i;

      List<Integer> list = intArrayAsList(a);
      Collections.shuffle(list);
      System.out.println(list);
    }
  }
}
