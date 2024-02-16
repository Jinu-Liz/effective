package practice.effective.chapter_01.item_03.enumtype;

/**
 * enum 타입으로 만들면 리플렉션이나 역직렬화에 안전하다.
 *
 * 리플렉션이 되지 않도록, 내부적으로 막아놓았다.
 */
public enum Elvis implements IElvis {

  INSTANCE;

  public void leaveTheBuilding() {
    System.out.println("기다려 자기야, 지금 나갈게!");
  }

  @Override
  public void sing() {
    System.out.println("노래부르기~");
  }
}
