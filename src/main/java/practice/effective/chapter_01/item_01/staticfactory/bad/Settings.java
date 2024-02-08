package practice.effective.chapter_01.item_01.staticfactory.bad;

import practice.effective.chapter_01.item_01.staticfactory.good.before.Difficulty;

/**
 * 이 클래스의 인스턴스는 #getInstance()를 통해 사용한다.
 * @see #getInstance()
 */
public class Settings {

  private boolean useAutoSteering;

  private boolean useABS;

  private Difficulty difficulty;

  private Settings() {}

  private static final Settings SETTINGS = new Settings();

  /**
   * 정적 팩터리 메서드의 단점
   * 1.
   * 정적 팩터리만을 쓰게 만들려면 생성자를 private으로 만들어야 한다.
   * 즉, 상속을 사용하지 못하게 된다.
   *
   * 2.
   * 메서드가 늘어나게 되면, 어떤 메서드가 인스턴스를 생성하는 메서드인지 찾기가 어렵다.
   */
  public static Settings getInstance() {
    return SETTINGS;
  }

}
