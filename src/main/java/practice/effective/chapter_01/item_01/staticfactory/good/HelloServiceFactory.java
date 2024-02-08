package practice.effective.chapter_01.item_01.staticfactory.good;

/**
 * [ 생성자 대신 정적 팩터리를 사용했을 때의 장점 ]
 * 인터페이스 타입을 사용하여, 여러 구현체를 상황에 맞게 사용하거나
 * 클래스의 경우, 여러 하위 클래스를 사용하여 유연함을 가질 수 있게 된다.
 *
 * 또한, 매개변수에 따라 다른 구현체를 사용할 수 있다.
 */
public class HelloServiceFactory {

  public static HelloService of(String lang) {
    if ("ko".equals(lang)) {

      return new KoreanHelloService();
    } else {

      return new EnglishHelloService();
    }
  }
}
