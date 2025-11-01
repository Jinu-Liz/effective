package practice.effective.chapter_06.item34.enumeration_method;

public class FruitStore {

  /**
   * 인터페이스를 사용하여 Fruit타입의 가격을 반환하도록 한다.
   */
  public int getPrice(Fruit fruit) {
    return fruit.getPrice();
  }
}
