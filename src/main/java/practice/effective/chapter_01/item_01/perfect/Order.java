package practice.effective.chapter_01.item_01.perfect;

import lombok.Data;
import practice.effective.chapter_01.item_01.staticfactory.good.Product;

@Data
public class Order {

  private boolean prime;

  private boolean urgent;

  private Product product;

  /**
   * Enum을 사용하면 특정 값들로만 입력을 제한할 수 있다.
   * Enum을 사용하지 않을 경우, 문자나 숫자로 표현할 것이다.
    */
  private OrderStatus orderStatus;

  /**
   * Enum을 사용하지 않을 경우,
   *
   * 0 - 주문받음
   * 1 - 준비중
   * 2 - 배송중
   * 3 - 배송완료
   *
   * 이라고 가정하고 사용할 수 있겠지만, 여기에 200이라는 값이 들어올 수도 있다.
   * 따라서 이를 검증하는 코드를 별도로 작성해야한다.
   */
  private int status;

  public static Order primeOrder(Product product) {
    Order order = new Order();
    order.prime = true;
    order.product = product;

    return order;
  }

  public static Order urgentOrder(Product product) {
    Order order = new Order();
    order.urgent = true;
    order.product = product;

    return order;
  }

}
