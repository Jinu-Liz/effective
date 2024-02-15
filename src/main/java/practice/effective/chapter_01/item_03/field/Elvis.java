package practice.effective.chapter_01.item_03.field;

import java.io.Serializable;

public class Elvis implements IElvis, Serializable {

  /**
   * 싱글톤 오브젝트
   */
  public static final Elvis INSTANCE = new Elvis();

  private static boolean created;

  /**
   * 리플렉션 방지
   * 리플렉션을 사용해 생성 시 created값 체크하여 예외 발생.
   */
  private Elvis() {
    if (created) throw new UnsupportedOperationException("can't be created by constructor.");

    created = true;
  }

  @Override
  public void leaveTheBuilding() {
    System.out.println("Whoa baby, I'm outta here!");
  }

  @Override
  public void sing() {
    System.out.println("I'll have a blue~ Christmas without you~");
  }

  /**
   * 역직렬화 시 해당 메서드 사용.
   * 반드시 이 이름으로 메서드를 만들어야 하며, 객체의 동일성을 보장하기 위해서는
   * 객체마다 해당 메서드를 선언해주어야한다.
   */
  private Object readResolve() {
    return INSTANCE;
  }
}
