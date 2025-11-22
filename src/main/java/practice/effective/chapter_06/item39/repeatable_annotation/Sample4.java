package practice.effective.chapter_06.item39.repeatable_annotation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Sample4 {

  @ExceptionTest(ArithmeticException.class)
  public static void m1() { // 성공해야 한다.
    int i = 0;
    i = i / i;
  }


  // 반복 가능 어노테이션은 이 코드와 동일.
  @ExceptionTestContainer(
    {
      @ExceptionTest(ArithmeticException.class),
      @ExceptionTest(IndexOutOfBoundsException.class),
    }
  )
  public static void m4() {}

  // 반복 가능 어노테이션을 사용한 코드
  @ExceptionTest(IndexOutOfBoundsException.class)
  @ExceptionTest(ArithmeticException.class)
  public static void doublyBad() {  // 성공해야한다.
    List<String> list = new ArrayList<>();
    list.addAll(5, null);
  }

  /**
   * 반복 가 능 어노테이션 사용 시, getAnnotationsByType으로 확인해보면
   * ExceptionTest와 ExceptionTestContainer 모두 존재한다고 나온다.
   * 그러나 isAnnotationPresent로 확인하면 ExceptionTest는 존재하지 않고
   * ExceptionTestContainer는 존재한다고 나온다.
   *
   * 이는 가시적인 것과 전혀 다른 결과이므로 주의.
   */
  public static void main(String[] args) throws NoSuchMethodException {
    Class<Sample4> sample4Class = Sample4.class;
    Method m1 = sample4Class.getMethod("m4");
    ExceptionTest[] annotationsByType = m1.getAnnotationsByType(ExceptionTest.class);
    for (ExceptionTest exceptionTest : annotationsByType) {
      System.out.println(exceptionTest);
    }

    ExceptionTestContainer[] containers = m1.getAnnotationsByType(ExceptionTestContainer.class);
    for (ExceptionTestContainer container : containers) {
      System.out.println(container);
    }

    System.out.println(m1.isAnnotationPresent(ExceptionTest.class));
    System.out.println(m1.isAnnotationPresent(ExceptionTestContainer.class));
  }
}
