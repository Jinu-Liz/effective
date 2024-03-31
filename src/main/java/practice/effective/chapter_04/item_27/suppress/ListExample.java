package practice.effective.chapter_04.item_27.suppress;

import java.util.Arrays;

public class ListExample {

  private int size;

  Object[] elements;

  /**
   * 이미 알고 있는 경고의 경우, 또는 안전하다고 판단하는 경우에
   * @SuppressWarnings 를 이용하여 표시할 수 있다.
   * 그러면 추후에 발생한 경고만 신경쓰면 된다.
   *
   * 해당 어노테이션은 가능한한 좁은 범위에 붙이는 것이 좋다.
   * 하나의 메서드에서 두 개의 경고가 발생할 경우, 경고가 묻혀 발견하지 못할 수도 있다.
   */
  public <T> T[] toArray(T[] a) {
    if (a.length < size) {
      /**
       * 이 어노테이션이 왜 여기에 선언되었는지 설명
       */
      @SuppressWarnings("unchecked")
      T[] result = (T[]) Arrays.copyOf(elements, size, a.getClass());

      return result;
    }
    System.arraycopy(elements, 0, a, 0, size);
    if (a.length > size) a[size] = null;

    return a;
  }

}
