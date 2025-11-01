package practice.effective.chapter_06.item34.integer_values;

public class AppleClient {

  /**
   * 상수로 사용하는 경우, 해당 상수가 변경되면
   * 사용하는 모든 클래스 파일을 다시 컴파일 해야한다.
   */
  public static void main(String[] args) {
    FruitStore fruitStore = new FruitStore();
    System.out.println(fruitStore.getPrice(Fruits.APPLE_GRANNY_SMITH));
  }
}
