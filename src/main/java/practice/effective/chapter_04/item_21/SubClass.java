package practice.effective.chapter_04.item_21;

/**
 * 부모의 private 메서드와 인터페이스의 메서드명이 같은 경우,
 * 자식이 해당 메서드를 사용하면 클래스와 인터페이스 중 클래스가 우선이므로
 * 부모의 private 메서드를 실행하려고 하게 된다.
 * 그러나 해당 메서드는 private이므로 에러가 발생하게 된다.
 *
 * 이와 같이 기존 인터페이스에 디폴트 메서드 구현을 추가하는 것은 위험하다.
 * 구현 클래스에 대해 아무것도 모른 채 합의 없이 무작정 '삽입'되기 때문이다.
 * 따라서, 인터페이스에 디폴트 메서드를 추가할 경우, 위와 같은 현상이 발생할 수 있다.
 */
public class SubClass extends SuperClass implements MarketInterface {
  public static void main(String[] args) {
    SubClass subClass = new SubClass();
    subClass.hello();
  }
}
