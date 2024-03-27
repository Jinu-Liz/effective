package practice.effective.chapter_04.item_24.localclass;

public class MyClass {

  private int number = 10;

  /**
   * 로컬 클래스.
   * 메서드가 너무 길어지고 복잡해지므로 잘 사용하지 않는다.
   */
  void doSomething() {
    class LocalClass {
      private void printNumber() {
        System.out.println(number);
      }
    }

    LocalClass localClass = new LocalClass();
    localClass.printNumber();
  }

  public static void main(String[] args) {
    MyClass myClass = new MyClass();
    myClass.doSomething();
  }

}
