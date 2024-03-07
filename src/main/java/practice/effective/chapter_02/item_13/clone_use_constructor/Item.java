package practice.effective.chapter_02.item_13.clone_use_constructor;

public class Item implements Cloneable {

  private String name;

  /**
   * 생성자 사용 시, 하위 클래스의 clone이 깨질 수 있음.
   */
  @Override
  protected Item clone() {
    Item item = new Item();
    item.name = this.name;
    return item;
  }
}
