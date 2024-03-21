package practice.effective.chapter_04.item_20.multipleinheritance;

public class MyCat extends AbstractCat implements Flyable {

  /**
   * 내부에 AbstractFlyable를 상속받은 클래스를 만든 후,
   * 내부 변수로 생성하여, 해당 클래스의 메서드에 위임함으로써
   * 다중 상속을 받은 듯한 효과를 낼 수 있다.
   */
  private MyFlyable myFlyable = new MyFlyable();

  @Override
  protected String sound() {
    return "인싸 고양이 두 마리가 나가신다!";
  }

  @Override
  protected String name() {
    return "유미";
  }

  public static void main(String[] args) {
    MyCat myCat = new MyCat();
    System.out.println(myCat.sound());
    System.out.println(myCat.name());
    myCat.fly();
  }

  @Override
  public void fly() {
    this.myFlyable.fly();
  }

  private class MyFlyable extends AbstractFlyable {
    @Override
    public void fly() {
      System.out.println("날아라.");
    }
  }
}
