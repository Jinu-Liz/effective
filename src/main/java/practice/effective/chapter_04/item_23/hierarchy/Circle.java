package practice.effective.chapter_04.item_23.hierarchy;

/**
 * 상속을 사용하여 구현하면 필요한 필드들만 사용하여 객체를 생성할 수 있다.
 */
public class Circle extends Figure {

  final double radius;

  public Circle(double radius) {
    this.radius = radius;
  }

  @Override
  double area() {
    return Math.PI * (radius * radius);
  }
}
