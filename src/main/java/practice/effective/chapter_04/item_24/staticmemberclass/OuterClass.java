package practice.effective.chapter_04.item_24.staticmemberclass;

public class OuterClass {

  private static int number = 10;

  /**
   * static 멤버 클래스는 바깥 클래스의 static한 필드에 접근할 수 있다.
   * 그리고 바깥 클래스의 인스턴스를 필요로하지 않고 독립적이다.
   */
  private static class InnerClass {
    void doSomething() {
      System.out.println(number);
    }
  }

  public static void main(String[] args) {
    InnerClass innerClass = new InnerClass();
    innerClass.doSomething();
  }
}
