package practice.effective.chapter_02.item_10.make_equals.record;

/**
 * record 클래스의 경우,
 * toString, equals, hashCode가 자동으로 정의되어 있다.
 */
public record Point(int x, int y) {

  public static void main(String[] args) {
    Point point = new Point(1, 2);
    Point point2 = new Point(1, 2);
    System.out.println(point.equals(point2));
  }
}
