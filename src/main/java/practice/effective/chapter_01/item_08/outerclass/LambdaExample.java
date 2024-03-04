package practice.effective.chapter_01.item_08.outerclass;

import java.lang.reflect.Field;

public class LambdaExample {

  private int value = 10;

  private static int staticValue = 20;

  /**
   * 바깥에 있는 값을 참조하게 되면, reference가 발생하게 된다.
   */
  private Runnable instanceLambda = () -> {
    System.out.println(value);
  };

  /**
   * static(정적) 변수를 참조하므로, reference가 발생하지 않는다.
   */
  private Runnable instanceLambda2 = () -> {
    System.out.println(staticValue);
  };

  public static void main(String[] args) {
    LambdaExample example = new LambdaExample();
    Field[] declaredFields = example.instanceLambda.getClass().getDeclaredFields();
    for (Field field : declaredFields) {
      System.out.println("field type : " + field.getType());
      System.out.println("field name : " + field.getName());
    }
  }
}
