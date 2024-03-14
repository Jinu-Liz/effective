package practice.effective.chapter_04.item_16.dimension;

import java.awt.*;

public class DimensionExample {

  public static void main(String[] args) {
    Button button = new Button("hello button");
    button.setBounds(0, 0, 20, 10);

    /**
     * java.awt 패키지가 아님에도 불구하고
     * 필드에 직접 접근하여 사용할 수 있다.
     */
    Dimension size = button.getSize();
    doSomething(size);

    System.out.println(size.height);
    System.out.println(size.width);
  }

  /**
   * 따라서 안전하게 사용하기 위하여 매개변수로 넘길 때마다 객체를 복사하여 사용해야 하는데,
   * 이는 성능 저하를 야기할 수 있다.
   */
  private static void doSomething(Dimension dimension) {
    Dimension dimension1 = new Dimension();
    dimension1.width = dimension.width;
    dimension1.height = dimension.height;
  }

}
