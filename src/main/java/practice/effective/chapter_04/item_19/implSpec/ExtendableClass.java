package practice.effective.chapter_04.item_19.implSpec;

/**
 * 상속을 사용할 때에는 어떤 식으로 동작하는지 구체적으로 기술하라.
 * 해당 클래스를 상속받아서 재정의하는 메서드가 그것을 알아야 하기 때문이다.
 * 어차피 캡슐화가 깨지기 때문에 동작방식을 알아야한다.
 */
public class ExtendableClass {

  /**
   * @implSpec
   * Please use System.out.println().
   */
  public void doSomething() {
    System.out.println("hello");
  }
}
