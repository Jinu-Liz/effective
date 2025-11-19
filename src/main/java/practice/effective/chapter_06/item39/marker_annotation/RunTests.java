package practice.effective.chapter_06.item39.marker_annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 어노테이션을 사용하면 원하는 메서드를
 * 별 다른 규칙없이 사용 가능하다.
 */
public class RunTests {
  public static void main(String[] args) {
    int tests = 0;
    int passed = 0;
    Class<?> testClass = Sample.class;
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
    }

    System.out.printf("테스트 : %d\n", tests);
    System.out.printf("성공 : %d", passed);
  }
}
