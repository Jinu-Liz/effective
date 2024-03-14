package practice.effective.chapter_04.item_16.point.field;

/**
 * 변수를 public으로 선언하여 바로 접근 가능하게 만들면
 * 변수명을 바꿀 때, 필드에 부가적인 작업을 하고 싶을 때 등
 * 많은 경우에 어려움이 있다.
 */
public class Point {

  /**
   * final이 아니기 때문에,
   * 언제 어디서 값이 바뀔지 모른다.
   */
  public double x;

  public double y;

  public static void main(String[] args) {
    Point point = new Point();
    point.x = 10;
    point.y = 20;

    System.out.println(point.x);
    System.out.println(point.y);
  }

}
