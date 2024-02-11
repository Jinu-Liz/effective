package practice.effective.chapter_01.item_01.perfect.framework.bridge._01_before;

public class KDA아리 implements Champion {

  @Override
  public void move() {
    System.out.println("KDA 아리 move");
  }

  @Override
  public void skillQ() {
    System.out.println("KDA 아리 skillQ");
  }

  @Override
  public void skillW() {
    System.out.println("KDA 아리 skillW");
  }

  @Override
  public void skillE() {
    System.out.println("KDA 아리 skillE");
  }

  @Override
  public void skillR() {
    System.out.println("KDA 아리 skillR");
  }
}
