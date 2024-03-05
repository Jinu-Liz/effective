package practice.effective.chapter_02.item_10;

// 단순한 불변 2차원 정수 점(point) 클래스
public class BadPoint {

  private final int x;

  private final int y;

  public BadPoint(int x, int y) {
    this.x = x;
    this.y = y;
  }

  // 리스코프 치환 원칙 위배
  @Override
  public boolean equals(Object o) {
    if (o == null || o.getClass() != getClass())
      return false;

    BadPoint p = (BadPoint) o;

    return p.x == this.x && p.y == this.y;
  }

  @Override
  public int hashCode() {
    return 31 * x + y;
  }

}
