package practice.effective.chapter_02.item_14.composition;

import lombok.Getter;

/**
 * 합성을 사용하면 상속받은 것이 없으니, Comparable을 새로 정의할 수 있다.
 */
public class NamedPoint implements Comparable<NamedPoint> {

  @Getter
  private final Point point;

  private final String name;

  public NamedPoint(Point point, String name) {
    this.point = point;
    this.name = name;
  }

  @Override
  public int compareTo(NamedPoint np) {
    int result = this.point.compareTo(np.point);
    if (result == 0) result = this.name.compareTo(np.name);

    return result;
  }
}
