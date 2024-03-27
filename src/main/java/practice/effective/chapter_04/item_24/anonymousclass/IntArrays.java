package practice.effective.chapter_04.item_24.anonymousclass;

import java.util.AbstractList;
import java.util.List;
import java.util.Objects;

public class IntArrays {
  static List<Integer> intArrayAsList(int[] a) {
    Objects.requireNonNull(a);

    /**
     * 내부에서 익명클래스를 구현하여 반환.
     * 지금은 람다나 메서드 레퍼런스 등을 사용하기 때문에
     * 거의 사용하지 않는다.
     */
    return new AbstractList<>() {
      @Override
      public Integer get(int index) {
        return a[index];    // 오토 박싱
      }

      @Override
      public Integer set(int index, Integer element) {
        int oldVal = a[index];
        a[index] = element;   // 오토 언박싱

        return oldVal;    // 오토 박싱
      }

      @Override
      public int size() {
        return a.length;
      }
    };
  }
}
