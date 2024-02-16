package practice.effective.chapter_01.item_03.staticfactory;

public class Elvis implements Singer {

  private static final Elvis INSTANCE = new Elvis();

  private Elvis() {}

  /**
   * 싱글턴을 쓰고 싶지 않은 경우, new로 새 객체를 만들도록하면 된다.
   * 즉, API를 바꾸지 않고도 싱글턴이 아니게 변경할 수 있다.
    */
  public static Elvis getInstance() { return INSTANCE; }

  public void leaveTheBuilding() {
    System.out.println("Whoa baby, I'm outta here!");
  }

  @Override
  public void sing() {
    System.out.println("노래부르기");
  }
}
