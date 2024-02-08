package practice.effective.chapter_01.item_01.staticfactory.bad;

import practice.effective.chapter_01.item_01.staticfactory.good.before.Difficulty;

public class Settings {

  private boolean useAutoSteering;

  private boolean useABS;

  private Difficulty difficulty;

  private Settings() {}

  private static final Settings SETTINGS = new Settings();

  /**
   * 정적 팩터리만을 쓰게 만들려면 생성자를 private으로 만들어야 한다.
   * 즉, 상속을 사용하지 못하게 된다.
   */
  public static Settings newInstance() {
    return SETTINGS;
  }

}
