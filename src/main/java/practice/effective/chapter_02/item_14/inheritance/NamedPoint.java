package practice.effective.chapter_02.item_14.inheritance;

import lombok.ToString;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Point에 Comparable을 상속받았기 때문에, 서브클래스에서 Comparable을 상속받을 수 없다.
 * 따라서, 상속에 Comparable을 사용하는 것은 권장하지 않는다.
 */
@ToString
public class NamedPoint extends Point {

  final private String name;

  public NamedPoint(int x, int y, String name) {
    super(x, y);
    this.name = name;
  }

  public static void main(String[] args) {
    NamedPoint p1 = new NamedPoint(1, 0, "jinuliz");
    NamedPoint p2 = new NamedPoint(1, 0, "jilinuz");

    Set<NamedPoint> points = new TreeSet<>(new Comparator<NamedPoint>() {

      @Override
      public int compare(NamedPoint o1, NamedPoint o2) {
        int result = Integer.compare(p1.getX(), p2.getX());

        if (result == 0) result = Integer.compare(p1.getY(), p2.getY());

        if (result == 0) result = p1.name.compareTo(p2.name);

        return result;
      }
    });

    points.add(p1);
    points.add(p2);

    System.out.println(points);
  }
}
