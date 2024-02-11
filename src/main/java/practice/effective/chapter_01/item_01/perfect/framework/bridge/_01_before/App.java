package practice.effective.chapter_01.item_01.perfect.framework.bridge._01_before;

public class App {

  /**
   * 스킨이 늘어나면, 해당 스킨을 사용하는 챔피언의 수만큼
   * class가 늘어난다.
   */
  public static void main(String[] args) {
    Champion kda아리 = new KDA아리();
    kda아리.move();
    kda아리.skillQ();
    kda아리.skillE();
  }
}
