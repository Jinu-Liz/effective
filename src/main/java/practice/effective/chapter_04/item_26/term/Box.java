package practice.effective.chapter_04.item_26.term;

/**
 * extends를 사용하여 특정 타입을 상속받는 타입으로 한정시킬 수 있다.
 */
public class Box<E extends Number> {

  private E item;

  private void add(E e) {
    this.item = e;
  }

  private E get() {
    return this.item;
  }

  public static void main(String[] args) {
    Box<Integer> box = new Box<>();
    box.add(10);
    printBox(box);
  }

  /**
   * ? 는 와일드카드(비한정적) 타입.
   * 아무런 타입이나 대응이 가능하다.
   */
  private static void printBox(Box<?> box) {
    System.out.println(box.get());
  }

}
