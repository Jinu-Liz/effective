package practice.effective.chapter_06.item34.enumeration_method;

/**
 * 타입이 다르기 때문에, 다른 enum에서 사용 중인
 * 이름을 사용해도 상관이 없다. (FUJI처럼)
 */
public enum Orange implements Fruit {

  NAVEL(200),
  TEMPLE(250),
  BLOOD(280),
  FUJI(300);

  private final int price;

  Orange(int price) {
    this.price = price;
  }

  @Override
  public int getPrice() {
    return this.price;
  }
}
