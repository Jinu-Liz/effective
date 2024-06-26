package practice.effective.chapter_04.item_32;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

// 미묘한 힙 오염 발생
public class PickTwo {

  /**
   * 자신의 제네릭 매개변수 배열의 참조를 노출한다. - 안전하지 않다.
   */
  static <T> T[] toArray(T... args) {
    return args;
  }

  static <T> T[] pickTwo(T a, T b, T c) {
    switch (ThreadLocalRandom.current().nextInt(3)) {
      case 0: return toArray(a, b);
      case 1: return toArray(a, c);
      case 2: return toArray(b, c);
    }

    throw new AssertionError();   // 도달할 수 없다.
  }

  public static void main(String[] args) {
    String[] attributes = pickTwo("좋은",  "빠른", "저렴한");
    System.out.println(Arrays.toString(attributes));
  }
}
