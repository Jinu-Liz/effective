package practice.effective.chapter_06.item39.annotation_with_array_parameter;

import java.util.ArrayList;
import java.util.List;

public class Sample3 {

  // 배열 매개변수의 경우, 원소 하나짜리도 처리 가능.
  @ExceptionTest(ArithmeticException.class)
  public static void m1() { // 성공해야 한다.
    int i = 0;
    i = i / i;
  }

  @ExceptionTest(ArithmeticException.class)
  public static void m2() { // 실패해야 한다. (다른 예외 발생)
    int[] a = new int[0];
    int i = a[1];
  }

  @ExceptionTest(ArithmeticException.class)
  public static void m3() {   // 실패해야 한다. (예외가 발생하지 않음)
  }

  // 배열 매개변수를 받는 어노테이션
  @ExceptionTest({ IndexOutOfBoundsException.class,
                  NullPointerException.class })
  public static void doublyBad() {  // 성공해야한다.
    List<String> list = new ArrayList<>();
    list.addAll(5, null);
  }
}
