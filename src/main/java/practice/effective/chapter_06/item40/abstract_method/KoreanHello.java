package practice.effective.chapter_06.item40.abstract_method;

/**
 * 위에 있는 것을 재정의 할 때는 override를 꼭 붙이는 습관을 가지는 것이 좋다.
 * 이상을 compile 시에 알 수 있기 때문
 */
public class KoreanHello extends AbstractHello {

  @Override
  public String hello() {
    return "안녕하세요";
  }

}
