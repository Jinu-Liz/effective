package practice.effective.chapter_04.item_23.hierarchy;

public class Square extends Figure {

  final double side;

  public Square(double side) {
    this.side = side;
  }

  @Override
  double area() {
    return this.side * this.side;
  }
}
