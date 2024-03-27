package practice.effective.chapter_04.item_24.memberclass;

public class OuterClass {

  private int number = 10;

  /**
   * 해당 메서드를 사용한다는 것은 OuterClass가 생성되었다는 뜻.
   * 따라서, 별도의 참조없이 내부 클래스를 사용할 수 있다.
   */
  void printNumber() {
    InnerClass innerClass = new InnerClass();
  }

  /**
   * static이 아닌 멤버 클래스의 경우, 바깥 클래스의 인스턴스에 대한 참조가 생긴다.
   * 즉, OuterClass가 없이는 사용할 수 없다.
   */
  private class InnerClass {
    void doSomething() {
      System.out.println(number);
      OuterClass.this.printNumber();
    }
  }

  public static void main(String[] args) {
    InnerClass innerClass = new OuterClass().new InnerClass();
    innerClass.doSomething();
  }
}
