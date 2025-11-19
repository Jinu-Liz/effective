package practice.effective.chapter_06.item39.naming_pattern;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 특정한 이름 규칙을 정하여 사용하는 명명 패턴의 경우
 * 1: 오타가 나면 안된다.
 * 2: 올바르게 사용되리라는 보장이 없다.
 * 3: 매개변수를 전달할 방법이 없다.
 * 라는 단점이 존재한다.
 */
public class RunTests {
  public static void main(String[] args) {
    int tests = 0;
    int passed = 0;
    Class<?> testClass = Sample.class;
    for (Method m : testClass.getDeclaredMethods()) {
      if (m.getName().startsWith("test")) {
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
