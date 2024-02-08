package practice.effective.chapter_01.item_01.staticfactory.good;

public interface HelloService {

  String hello();

  /**
   * 기존에는 인터페이스에 static을 선언할 수 없었으나,
   * Java8 이후에는 가능해졌다.
    */
  static HelloService of(String lang) {
    if ("ko".equals(lang)) {

      return new KoreanHelloService();
    } else {

      return new EnglishHelloService();
    }
  }
}
