package practice.effective.chapter_01.item_04;

/**
 * 추상클래스를 상속받은 서브클래스가 있는 경우, 자동으로 추상클래스의 기본 생성자가 만들어진다.
 */
public class DefaultUtilityClass extends UtilityClassAbst {
  public static void main(String[] args) {

    DefaultUtilityClass utilityClass = new DefaultUtilityClass();
  }
}
