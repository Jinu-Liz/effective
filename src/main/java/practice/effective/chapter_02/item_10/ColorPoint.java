package practice.effective.chapter_02.item_10;

public class ColorPoint extends Point {

  /**
   * 하위 클래스에 필드가 추가되어 있다면,
   * 대칭성 / 추이성을 위반하지 않는 (equals 규약을 지키는)
   * 안전한 equals를 만드는 방법이 존재하지 않는다.
   */
  private final Color color;

  public ColorPoint(int x, int y, Color color) {
    super(x, y);
    this.color = color;
  }

  /**
   * 대칭성 위배.
   * ColorPoint와 Point를 비교하게 되면 대칭성이 깨진다.
   * ColorPoint는 Point를 상속받았기 때문에 Point 타입이지만,
   * Point는 ColorPoint 타입이 아니다.
   */
  @Override
  public boolean equals(Object o) {
    if (!(o instanceof ColorPoint))
      return false;

    return super.equals(o) && ((ColorPoint) o).color == this.color;
  }

  public static void main(String[] args) {
    Point p = new Point(1, 2);
    ColorPoint cp = new ColorPoint(1, 2, Color.RED);
    System.out.println(p.equals(cp) + " " + cp.equals(p));
  }
}
