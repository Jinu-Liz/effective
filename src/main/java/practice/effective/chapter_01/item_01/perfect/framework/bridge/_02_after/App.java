package practice.effective.chapter_01.item_01.perfect.framework.bridge._02_after;


public class App {

  public static void main(String[] args) {
    Champion kda = new 아리(new KDA());
    kda.skillQ();
    kda.skillW();

    Champion poolParty아리 = new 아리(new PoolParty());
    poolParty아리.skillR();
    poolParty아리.skillW();
  }
}
