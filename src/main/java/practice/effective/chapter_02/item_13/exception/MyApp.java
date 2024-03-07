package practice.effective.chapter_02.item_13.exception;

public class MyApp {

  public void hello() {
    System.out.println("hello");
    throw new MyException();
  }

  /**
   * 귀찮음에도 불구하고 CheckedException을 사용하는 이유는
   * 해당 메서드가 API이기 때문이다.
   * Client에게 해당 메서드에서 CheckedException이 발생할 수 있다고 경고할 수 있다.
   * Client는 해당 경고를 보고 다른 수행을 할 수 있다.
   * 따라서, Client로 인하여 처리가 가능한 경우, 적절한 알림을 통해 정상 처리로 유도하도록 하는 것이 좋은 API이다.
   */
  public void checkedHello(String name) throws MyCheckedException {
    if (name.equals("푸틴")) throw new MyCheckedException();

    System.out.println("hello");
  }

  /**
   * 사용하기 쉽고, Client에서 Exception에 대해 신경쓰지 않아도 된다.
   * CheckedException을 사용하게 되면 try-catch로 묶어주거나 Client에서 별도로 처리해야하는 등 귀찮다.
   *
   * UnCheckedException이 발생하면 Client 측에서는 할 수 있는 것이 아무것도 없는 경우에 사용한다.
   * 따라서, 알림이라도 줄 때 사용.
   */
  public static void main(String[] args) throws MyCheckedException {
    MyApp myApp = new MyApp();
    myApp.hello();

    try {
      myApp.checkedHello("푸틴");
    } catch (MyCheckedException e) {
      myApp.checkedHello("지누리즈");
    }
  }
}
