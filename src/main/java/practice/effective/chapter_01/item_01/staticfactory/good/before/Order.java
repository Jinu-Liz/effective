package practice.effective.chapter_01.item_01.staticfactory.good.before;

import practice.effective.chapter_01.item_01.staticfactory.good.Product;

public class Order {

  private boolean prime;

  private boolean urgent;

  private Product product;

  public Order(boolean prime, Product product) {
    this.prime = prime;
    this.product = product;
  }

  /**
   * 시그니처의 경우에 타입과 순서를 가지고 중복 판단을 하므로
   * 이와 같이 우회할 수 있으나, 정적 팩터리 메서드를 통해 해결하는 것이 좋다.
   */
  public Order(Product product, boolean urgent) {
    this.urgent = urgent;
    this.product = product;
  }

}
