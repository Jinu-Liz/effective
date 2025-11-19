package practice.effective.chapter_06.item39.annotation_with_parameter;

import practice.effective.chapter_06.item39.marker_annotation.Sample;
import practice.effective.chapter_06.item39.marker_annotation.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RunTests {
  public static void main(String[] args) {
    int tests = 0;
    int passed = 0;
    Class<?> testClass = Sample2.class;
    for (Method m : testClass.getDeclaredMethods()) {
      if (m.isAnnotationPresent(Test.class)) {
        tests++;
        try {
          m.invoke(null);
          passed++;
        } catch (InvocationTargetException e) {
          Throwable cause = e.getCause();
          System.out.println(m + " 실패 : " + cause);
        } catch (Exception e) {
          System.out.println("잘못 사용한 테스트 : " + m);
        }
      }

      if (m.isAnnotationPresent(ExceptionTest.class)) {
        tests++;
        try {
          m.invoke(null);
          System.out.printf("테스트 %s 실패: 예외를 던지지 않음%n", m);
        } catch (InvocationTargetException e) {
          Throwable cause = e.getCause();
          Class<? extends Throwable> excType = m.getAnnotation(ExceptionTest.class).value();
          if (excType.isInstance(cause)) {
            passed++;
          } else {
            System.out.printf("테스트 %s 실패 : 기대한 예외 %s, 발생한 예외 %s%n", m, excType.getName(), cause);
          }
        } catch (Exception e) {
          System.out.println("잘못 사용한 @ExceptionTest: " + m);
        }
      }
    }

    System.out.printf("테스트 : %d\n", tests);
    System.out.printf("성공 : %d", passed);
  }
}
