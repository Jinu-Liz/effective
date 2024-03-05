package practice.effective.chapter_02.item_10;

import java.util.Set;

public class CounterPointTest {

  private static final Set<BadPoint> unitCircle = Set.of(
    new BadPoint(1, 0), new BadPoint(0, 1),
    new BadPoint(-1, 0), new BadPoint(0, -1)
  );

  /**
   * 상위 클래스인 BadPoint를 넣었을 경우와
   * 하위 클래스인 CounterPoint를 넣었을 경우의 결과가 같아야 한다.
   * 하위 클래스는 상위 클래스를 완전히 대체할 수 있어야하며,
   * 그렇지 않은 경우, 리스코프 치환 원칙에 위배된다.
   */
  public static boolean onUnitCircle(BadPoint p) {
    return unitCircle.contains(p);
  }

  public static void main(String[] args) {
    BadPoint p1 = new BadPoint(1, 0);
    BadPoint p2 = new CounterPoint(1, 0);

    // true를 출력
    System.out.println(onUnitCircle(p1));

    // true를 출력해야 하지만, Point의 equals가 getClass를 사용해 작성되었다면 그렇지 않다.
    System.out.println(onUnitCircle(p2));
  }
}
