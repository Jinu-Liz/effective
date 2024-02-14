package practice.effective.chapter_01.item_02.builder.illegalargumentexception;

import java.time.LocalDate;

public class Order {

  /**
   * 메서드에 Exception을 throws 하지 않아도 되는데, 하는 것은 Client에게 명시적으로 알려주기 위해서.
   * 그러나 unchecked exception이 많아지게 되면 가독성이 떨어지게 되므로, checked exception만 작성하여
   * Client에 후속작업을 해야함을 명시적으로 알려주는 용도로 사용.
   *
   * 해당 throws를 보고, 이 메서드를 사용할 경우 어떤 예외가 발생할 수 있을지 가늠할 수 있다.
   *
   * 보통의 경우, RuntimeException을 사용한다.
   * 원하면 catch를 할 수도 있고, 선언을 할 수도 있으므로.
   * 그러나 에러가 발생했을 때, Client 측에서 후속작업을 해주기를 바라는 경우에는 checked exception을 써야한다.
   */
  public void updateDeliveryDate(LocalDate deliveryDate) throws IllegalArgumentException, NullPointerException {
    if (deliveryDate == null) throw new NullPointerException("deliveryDate can't be null");

    if (deliveryDate.isBefore(LocalDate.now())) {
      throw new IllegalArgumentException("deliveryDate can't be earlier than " + LocalDate.now());
    }
  }

}
