package practice.effective.chapter_06.item37.enummap;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class EnumMapExample {

  enum LifeCycle { ANNUAL, PERENNIAL, BIENNIAL }

  public static void main(String[] args) {
    EnumMap<LifeCycle, Object> plantsByLifeCycle = new EnumMap<>(LifeCycle.class);
    plantsByLifeCycle.put(LifeCycle.PERENNIAL, "라벤더");
    plantsByLifeCycle.put(LifeCycle.ANNUAL, "바질");
    plantsByLifeCycle.put(LifeCycle.BIENNIAL, "파슬리");
    plantsByLifeCycle.put(null, "타임");    // EnumMap은 설계상 null 키를 허용하지 않는다.
    System.out.println(plantsByLifeCycle);

    /**
     * EnumMap은 기본적으로 동기화 기능을 가지고 있지 않기 때문에
     * 멀티쓰레드 환경에서 사용할 시, synchronizedMap을 사용하여 동기화처리를 해주어야 한다.
     */
    Map<LifeCycle, Object> plantsByLifeCycle2 = Collections.synchronizedMap(new EnumMap<>(LifeCycle.class));
    System.out.println(plantsByLifeCycle2);
  }

}
