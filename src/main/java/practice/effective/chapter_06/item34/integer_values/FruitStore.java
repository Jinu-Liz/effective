package practice.effective.chapter_06.item34.integer_values;

public class FruitStore {

  /**
   * 메서드로 받는 인자는 int값이면 다 넘어오기 때문에
   * 넘어온 값이 과일인지 구분을 할 수 없다.
   * 즉, 타입안정성을 보장할 수 없다.
   *
   * 순회하면서 체크하는 로직을 만들기도 쉽지 않고, 변경사항이 생겼을 경우 사용하는 곳마다 수정사항이 생긴다.
   */
  public int getPrice(int fruit) {
    return switch (fruit) {
      case Fruits.APPLE_FUJI -> 100;

      case Fruits.APPLE_PIPPIN -> 200;

      case Fruits.APPLE_GRANNY_SMITH -> 300;

      case Fruits.ORANGE_NAVEL -> 150;

      case Fruits.ORANGE_TEMPLE -> 250;

      case Fruits.ORANGE_BLOOD -> 350;

      default -> throw new IllegalArgumentException("No such fruit.");
    };
  }

  public String getNameOfFruit(int fruit) {
    return switch (fruit) {
      case Fruits.APPLE_FUJI -> "APPLE_FUJI";
      case Fruits.APPLE_PIPPIN -> "APPLE_PIPPIN";
      case Fruits.APPLE_GRANNY_SMITH -> "APPLE_GRANNY_SMITH";
      case Fruits.ORANGE_NAVEL -> "ORANGE_NAVEL";
      case Fruits.ORANGE_TEMPLE -> "ORANGE_TEMPLE";
      case Fruits.ORANGE_BLOOD -> "ORANGE_BLOOD";
      default -> throw new IllegalArgumentException("No such fruit.");
    };
  }


  public static void main(String[] args) {
    FruitStore fruitStore = new FruitStore();
    System.out.println(fruitStore.getPrice(Fruits.APPLE_FUJI));
    ;

  }
}
