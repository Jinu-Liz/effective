package practice.effective.chapter_01.item_01.staticfactory.good;

public class KoreanHelloService implements HelloService {

  @Override
  public String hello() {
    return "안녕하세요!";
  }
}
