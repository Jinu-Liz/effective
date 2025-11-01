package practice.effective.chapter_06.item34.enumeration_method;

/**
 * 컴파일 내용을 보면, Apple 타입이다.
 * 따라서, 런타임이 아닌 컴파일 에러가 발생한다.
 */
public class AppleClient {

  public static void main(String[] args) {
    FruitStore fruitStore = new FruitStore();
    System.out.println(fruitStore.getPrice(Apple.GRANNY_SMITH));  // Apple 이외의 타입은 사용할 수 없다.
  }
}
