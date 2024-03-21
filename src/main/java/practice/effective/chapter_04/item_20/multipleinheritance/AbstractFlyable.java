package practice.effective.chapter_04.item_20.multipleinheritance;

public class AbstractFlyable implements Flyable {

  @Override
  public void fly() {
    System.out.println("너랑 딱 붙어있을게!");
  }
}
