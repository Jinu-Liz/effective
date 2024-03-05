package practice.effective.chapter_02.item_10;

public class ColorPoint2 extends Point {

  private final Color color;

  public ColorPoint2(int x, int y, Color color) {
    super(x, y);
    this.color = color;
  }

  /**
   * 추이성 위배
   */
  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Point))
      return false;

    /**
     * 해당 로직을 다른 서브클래스에도 만들 경우,
     * 서로 호출되면서 stack overflow가 발생하게 된다.
     */
    if (!(o instanceof ColorPoint2))
      return o.equals(this);

    // o가 ColorPoint면 색상까지 비교한다.
    return super.equals(o) && ((ColorPoint2) o).color == this.color;
  }

  /**
   * A == B이고, B == C이면 A == C 이어야 한다. 이것이 추이성.
   * 그런데, 아래 예시의 경우 true true false가 나오므로 추이성이 깨진다.
   */
  public static void main(String[] args) {
    ColorPoint2 cp = new ColorPoint2(1, 2, Color.RED);
    Point p = new Point(1, 2);
    ColorPoint2 cp2 = new ColorPoint2(1, 2, Color.BLUE);
    System.out.printf("%s %s %s%n", cp.equals(p), p.equals(cp2), cp.equals(cp2));
  }
}
