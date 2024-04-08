package practice.effective.chapter_04.item_33.super_type_token;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenericTypeInfer {

  static class Super<T> {
    T value;
  }

  static class Sub extends Super<String> {

  }

  /**
   * 아래와 같은 방법으로 제네릭의 타입을 알아내어, List 내의 타입을 알아낼 수 있다.
   */
  public static void main(String[] args) throws NoSuchFieldException {
    /**
     * 기본적으로 제너럴의 타입은 Object
     */
    Super<String> stringSuper = new Super<>();
    System.out.println(stringSuper.getClass().getDeclaredField("value").getType());

    /**
     * 하위 클래스를 이용하여 제네릭의 타입을 알아내기
     */
    Type type = Sub.class.getGenericSuperclass();
    ParameterizedType pType = (ParameterizedType) type;
    System.out.println(pType.getActualTypeArguments()[0]);

    /**
     * 익명 클래스를 이용하여 제네릭의 타입을 알아내기
     */
    Type type2 = (new Super<String>(){}).getClass().getGenericSuperclass();
    ParameterizedType pType2 = (ParameterizedType) type2;
    System.out.println(pType2.getActualTypeArguments()[0]);

  }
}
