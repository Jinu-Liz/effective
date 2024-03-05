package practice.effective.chapter_02.item_10;

// 단순한 불변 2차원 정수 점(point) 클래스
public class Point {

  private final int x;

  private final int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Point))
      return false;

    Point p = (Point) o;

    return p.x == this.x && p.y == this.y;
  }

}
