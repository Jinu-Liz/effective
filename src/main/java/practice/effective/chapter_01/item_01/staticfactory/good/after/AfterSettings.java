package practice.effective.chapter_01.item_01.staticfactory.good.after;

import practice.effective.chapter_01.item_01.staticfactory.good.before.Difficulty;

public class AfterSettings {

  private boolean useAutoSteering;

  private boolean useABS;

  private Difficulty difficulty;

  private AfterSettings() {}

  private static final AfterSettings SETTINGS = new AfterSettings();

  public static AfterSettings newInstance() {
    return SETTINGS;
  }

  public static void main(String[] args) {
    // 매번 새로운 인스턴스가 생성됨.
    System.out.println(new AfterSettings());
    System.out.println(new AfterSettings());
    System.out.println(new AfterSettings());
  }

}
