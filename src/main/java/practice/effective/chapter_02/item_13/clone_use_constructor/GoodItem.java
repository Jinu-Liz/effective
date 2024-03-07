package practice.effective.chapter_02.item_13.clone_use_constructor;

public class GoodItem implements Cloneable {

  private String name;

  /**
   * 생성자 사용 시, 하위 클래스의 clone이 깨질 수 있음.
   */
  @Override
  protected GoodItem clone() {
    GoodItem result = null;
    try {
      /**
       * 해당 순간에 반환 타입이 GoodItem이라고 생각되지만,
       * 하위 타입에서 호출할 경우, 하위 타입으로 나가게 된다.
       */
      result = (GoodItem) super.clone();

      return result;
    } catch (CloneNotSupportedException e) {
      throw new AssertionError();
    }
  }
}
