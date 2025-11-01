package practice.effective.chapter_06.item34.enumeration_method;

/**
 * 각 타입마다 값과 메서드를 설정하여
 * 다른 곳에서 별도로 메서드를 만들어 처리하지 않아도 되도록 구성할 수 있다.
 */
public enum Apple implements Fruit {

  FUJI(120),
  PIPPIN(150),
  GRANNY_SMITH(180);

  private final int price;

  Apple(int price) {
    this.price = price;
  }

  @Override
  public int getPrice() {
    return this.price;
  }
}
