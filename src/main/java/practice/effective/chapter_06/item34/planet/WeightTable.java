package practice.effective.chapter_06.item34.planet;

public class WeightTable {

  public static void main(String[] args) {
    double earthWeight = 10;
    double mass = earthWeight / Planet.EARTH.surfaceGravity();
    Planet[] values = Planet.values();

    /**
     * values는 Enum에 정의된 순서에 맞게 반환한다.
     * 그러나, 해당 메서드를 이용하여 처리할 경우에 순서에 의존한 처리를 하면 안된다.
     * 중간에 추가될 수 있기 때문.
     */
    for (Planet p : values) {
      System.out.printf("%s에서의 무게는 %f이다.%n", p, p.surfaceWeight(mass));
    }

  }
}
