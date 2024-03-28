package practice.effective.chapter_04.item_26.terms;

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

  /**
   * 컴파일 후에는 사실상 raw타입이고, 자바 컴파일러가 캐스팅하는 코드를 삽입한다.
   * 이는 자바 예전 버전과의 호환성을 위하여.
   */
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
