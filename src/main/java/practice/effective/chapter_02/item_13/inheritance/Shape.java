package practice.effective.chapter_02.item_13.inheritance;

/**
 * 일반적으로 상속용 클래스에 Cloneable 인터페이스 사용을 권장하지 않음.
 * 해당 클래스를 확장하려는 프로그래머에게 많은 부담을 주기 때문.
 */
public abstract class Shape implements Cloneable {

  private int area;

  public abstract int getArea();

  /**
   * 부담을 덜어주기 위해서는 기본 clone() 구현체를 제공하여,
   * Cloneable 구현 여부를 서브 클래스가 선택할 수 있게끔 만드는 것이 좋다.
   */
  @Override
  protected Object clone() throws CloneNotSupportedException {
    return super.clone();
  }

  /**
   * 아니면, Cloneable 구현을 막아서 하위 클래스들이 사용하지 못하도록 만들 수도 있다.
   */
  protected final Object clone2() throws CloneNotSupportedException {
    throw new CloneNotSupportedException();
  }
}
