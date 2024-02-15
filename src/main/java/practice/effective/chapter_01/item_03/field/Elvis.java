package practice.effective.chapter_01.item_03.field;

public class Elvis implements IElvis {

  /**
   * 싱글톤 오브젝트
   */
  public static final Elvis INSTANCE = new Elvis();

  private Elvis() {}

  @Override
  public void leaveTheBuilding() {
    System.out.println("Whoa baby, I'm outta here!");
  }

  @Override
  public void sing() {
    System.out.println("I'll have a blue~ Christmas without you~");
  }
}