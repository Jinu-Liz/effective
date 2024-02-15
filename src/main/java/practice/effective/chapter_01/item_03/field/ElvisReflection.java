package practice.effective.chapter_01.item_03.field;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ElvisReflection {

  /**
   * 리플렉션을 사용하면, 싱글턴 패턴을 깨고 다른 여러 인스턴스를 만들 수 있다.
   */
  public static void main(String[] args) {
    try {
      Constructor<Elvis> defaultConstructor = Elvis.class.getDeclaredConstructor();
      defaultConstructor.setAccessible(true);
      Elvis elvis1 = defaultConstructor.newInstance();
      Elvis elvis2 = defaultConstructor.newInstance();
      Elvis.INSTANCE.sing();
      System.out.println(elvis1 == elvis2);   // false
      System.out.println(elvis1 == Elvis.INSTANCE);   // false
    } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
     e.printStackTrace();
    }
  }
}
