package practice.effective.chapter_01.item_01.perfect.framework.bridge._02_after;


public class DefaultChampion implements Champion {

  /**
   * 스킨을 추상화한 후에, 구현체만 바꾸면 일일이 class를 만들 필요가 없다.
   */
  private Skin skin;

  private String name;

  public DefaultChampion(Skin skin, String name) {
    this.skin = skin;
    this.name = name;
  }

  @Override
  public void move() {
    System.out.printf("%s %s move\n", skin.getName(), this.name);
  }

  @Override
  public void skillQ() {
    System.out.printf("%s %s Q\n", skin.getName(), this.name);
  }

  @Override
  public void skillW() {
    System.out.printf("%s %s W\n", skin.getName(), this.name);
  }

  @Override
  public void skillE() {
    System.out.printf("%s %s E\n", skin.getName(), this.name);
  }

  @Override
  public void skillR() {
    System.out.printf("%s %s R\n", skin.getName(), this.name);
  }
}
