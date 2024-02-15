package practice.effective.chapter_01.item_03.field;

public class Elvis {

  /**
   * 싱글톤 오브젝트
   */
  public static final Elvis INSTANCE = new Elvis();

  private Elvis() {}

  public void leaveTheBuilding() {
    System.out.println("Whoa baby, I'm outta here!");
  }

  public void sing() {
    System.out.println("I'll have a blue~ Christmas without you~");
  }
}
