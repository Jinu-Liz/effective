package practice.effective.chapter_01.item_01.staticfactory.good._02_after;

import practice.effective.chapter_01.item_01.staticfactory.good.Product;

public class Order {

  private boolean prime;

  private boolean urgent;

  private Product product;

  /**
   * 만들고자하는 바를, 팩터리 메서드의 이름을 통하여
   * 보다 명확하게 표현할 수 있다.
   * 따라서, 생성자의 시그니처가 중복되는 경우에 고려해보는 것이 좋다.
   */
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
