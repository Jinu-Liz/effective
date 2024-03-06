package practice.effective.chapter_02.item_10;

public class SmellPoint extends Point {

  private String smell;

  public SmellPoint(int x, int y, String smell) {
    super(x, y);
    this.smell = smell;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Point))
      return false;

    if (!(o instanceof SmellPoint))
      return o.equals(this);

    // o가 ColorPoint면 색상까지 비교한다.
    return super.equals(o) && ((SmellPoint) o).smell.equals(this.smell);
  }
}
