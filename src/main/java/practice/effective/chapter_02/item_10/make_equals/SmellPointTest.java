package practice.effective.chapter_02.item_10.make_equals;

import practice.effective.chapter_02.item_10.Color;
import practice.effective.chapter_02.item_10.ColorPoint2;
import practice.effective.chapter_02.item_10.SmellPoint;

/**
 * 서로 비교하는 순환이 일어나, StackOverflow 에러가 난다.
 */
public class SmellPointTest {
  public static void main(String[] args) {
    SmellPoint p1 = new SmellPoint(1, 0, "sweat");
    ColorPoint2 p2 = new ColorPoint2(1, 0, Color.RED);
    p1.equals(p2);
  }
}
