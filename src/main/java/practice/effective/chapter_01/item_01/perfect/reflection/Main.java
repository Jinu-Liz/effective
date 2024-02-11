package practice.effective.chapter_01.item_01.perfect.reflection;

import practice.effective.chapter_01.item_01.staticfactory.good.HelloServiceEx;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

    /**
     * 리플렉션을 통해 인스턴스를 가져오고, 해당 인스턴스의 메서드를 호출할 수 있다.
     * 이런 기능을 통해, 접근지시자 관계없이 메서드나 필드를 가져오고 실행시킬 수 있다. (private도 가능)
     */
    Class<?> aClass = Class.forName("practice.effective.chapter_01.item_01.staticfactory.ChineseHelloService");
    Constructor<?> constructor = aClass.getConstructor();
    HelloServiceEx helloServiceEx = (HelloServiceEx) constructor.newInstance();
    System.out.println(helloServiceEx.hello());

    Arrays.stream(aClass.getDeclaredMethods())
      .forEach(System.out::println);
  }
}
