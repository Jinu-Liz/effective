package practice.effective.chapter_04.item_19.constructor;

public class Super {

  /**
   * 생성자가 재정의 가능한 메서드를 호출하면 안된다.
   */
  public Super() {
    overrideMe();
  }

  public void overrideMe() {}
}
