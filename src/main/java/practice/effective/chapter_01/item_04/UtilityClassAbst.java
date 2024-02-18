package practice.effective.chapter_01.item_04;

/**
 * 추상클래스를 상속받은 서브클래스가 있는 경우, 자동으로 추상클래스의 기본 생성자가 만들어진다.
 * 또한, 추상클래스로 만드는 경우 해당 클래스를 상속받아 사용하는 것인지 혼란을 야기할 수 있다.
 * 따라서, 유틸리티성 클래스를 추상클래스로 만드는 것은 좋지 않다.
 */
public abstract class UtilityClassAbst {

  public UtilityClassAbst() {
    System.out.println("Constructor");
  }

  public static String hello() {
    return "hello";
  }

}
