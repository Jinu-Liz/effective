package practice.effective.chapter_01.item_08.outerclass;

import java.lang.reflect.Field;

public class OuterClass {

  private void hi() {

  }

  /**
   * InnerClass에서 OuterClass에 대한 참조를 할 수 있다.
   * 따라서 참조가 발생하기 때문에 내부클래스로 선언할 경우,
   * static으로 만들어주어야 한다.
   */
  class InnerClass{
    public void hello() {
      OuterClass.this.hi();
    }
  }

  public static void main(String[] args) {
    OuterClass outerClass = new OuterClass();
    InnerClass innerClass = outerClass.new InnerClass();
    System.out.println(innerClass);

    outerClass.printConstructor();
  }

  private void printConstructor() {
    Field[] declaredField = InnerClass.class.getDeclaredFields();
    for (Field field : declaredField) {
      System.out.println("field type : " + field.getType());
      System.out.println("field name : " + field.getName());
    }
  }

}
