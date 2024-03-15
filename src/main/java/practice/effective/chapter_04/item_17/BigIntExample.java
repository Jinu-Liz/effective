package practice.effective.chapter_04.item_17;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class BigIntExample {
  public static void main(String[] args) {
    BigInteger ten = BigInteger.TEN;

    /**
     * 내부 레퍼런스를 매개변수로 넘겨 새로운 객체를 만든다.
     * 이럴 경우, 레퍼런스 값이 바뀌면 관련된 모든 객체 속 레퍼런스 값이 바뀌지만
     * final을 통해 불변으로 만들었기 때문에, 그럴 걱정없이 사용할 수 있다.
     */
    BigInteger minusTen = ten.negate();

    final Set<Point> points = new HashSet<>();
    Point firstPoint = new Point(1, 2);
    points.add(firstPoint);

    /**
     * Set을 final로 만들어도, 내부 객체가 변하는 것을 막을수는 없다.
     * 따라서 객체를 불변으로 만들면 이와 같은 일을 방지할 수 있다.
     */
    firstPoint.setX(10);
    firstPoint.setY(20);

  }
}
