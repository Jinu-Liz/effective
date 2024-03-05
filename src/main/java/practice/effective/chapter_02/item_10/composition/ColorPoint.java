package practice.effective.chapter_02.item_10.composition;

import java.util.Objects;

// 코드 10-5 equals 규약을 지키면서 값 추가하기
public class ColorPoint {

  private final Point point;

  private final Color color;

  public ColorPoint(int x, int y, Color color) {
    this.point = new Point(x, y);
    this.color = Objects.requireNonNull(color);
  }

  /**
   * 이 ColorPoint의 Point 뷰를 반환
   */
  public Point asPoint() {
    return this.point;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof ColorPoint))
      return false;

    ColorPoint cp = (ColorPoint) o;

    return cp.point.equals(this.point) && cp.color.equals(this.color);
  }

  @Override
  public int hashCode() {
    return 31 * this.point.hashCode() + this.color.hashCode();
  }

}
