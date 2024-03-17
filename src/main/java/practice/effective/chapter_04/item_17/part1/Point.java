package practice.effective.chapter_04.item_17.part1;

/**
 * public 메서드를 이용하면 부가적인 작업이 가능하다.
 * 따라서 더욱 유연하게 사용 가능하다.
 */
public class Point {

  private double x;

  private double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double getX() {
    // 부가 작업
    return x;
  }

  public void setX(double x) {
    // 부가 작업
    this.x = x;
  }

  public double getY() {
    return y;
  }

  public void setY(double y) {
    this.y = y;
  }
}
