package practice.effective.chapter_04.item_23.taggedclass;

/**
 * 태그 달린 클래스 - 클래스 계층구조보다 훨씬 나쁘다.
 *
 * Figure의 모양에는 RECTANGLE, CIRCLE이 있는데, 각각 필요한 필드가 다르다.
 * 그러한 필드를 하나의 클래스에서 모두 선언하여 사용하면, 해당 객체가 생성될 때
 * 사용하지 않는 필드들도 선언해야하기 때문에 메모리를 더 사용하게 된다.
 *
 * 또한, final은 반드시 초기화를 해주어야하기 때문에,
 * RECTANGLE을 사용하는데 CIRCLE을 초기화 해주어야 한다.
 */
public class Figure {
  enum Shape { RECTANGLE, CIRCLE, SQUARE }

  final Shape shape;

  double length;

  double width;

  double radius;

  Figure(double radius) {
    this.shape = Shape.CIRCLE;
    this.radius = radius;
  }

  Figure(double length, double width) {
    if (this.length == this.width) {
      this.shape = Shape.SQUARE;
    } else {
      this.shape = Shape.RECTANGLE;
    }

    this.length = length;
    this.width = width;
  }

  double area() {
    switch (shape) {
      case RECTANGLE, SQUARE:
        return length * width;

      case CIRCLE:
        return Math.PI * (radius * radius);

      default:
        throw new AssertionError(shape);
    }
  }
}
