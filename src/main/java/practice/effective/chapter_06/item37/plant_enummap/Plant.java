package practice.effective.chapter_06.item37.plant_enummap;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

public class Plant {

  enum LifeCycle {
    ANNUAL, PERENNIAL, BIENNIAL
  }

  final String name;

  final LifeCycle lifeCycle;

  public Plant(String name, LifeCycle lifeCycle) {
    this.name = name;
    this.lifeCycle = lifeCycle;
  }

  @Override
  public String toString() {
    return name;
  }

  public static void main(String[] args) {
    Plant[] garden = {
      new Plant("바질", LifeCycle.ANNUAL),
      new Plant("캐러웨이", LifeCycle.BIENNIAL),
      new Plant("딜", LifeCycle.ANNUAL),
      new Plant("라벤더", LifeCycle.PERENNIAL),
      new Plant("파슬리", LifeCycle.BIENNIAL),
      new Plant("로즈마리", LifeCycle.PERENNIAL)
    };

    // EnumMap을 사용해 데이터와 열거 타입을 매핑한다.
    Map<LifeCycle, Set<Plant>> plantByLifeCycle = new EnumMap<>(LifeCycle.class);
    for (LifeCycle lifeCycle : LifeCycle.values()) {
      plantByLifeCycle.put(lifeCycle, new HashSet<>());
    }

    for (Plant plant : garden) {
      plantByLifeCycle.get(plant.lifeCycle).add(plant);
      System.out.println(plantByLifeCycle);
    }

    /**
     * 스트림 사용한 코드 1 - EnumMap을 사용하지 않는다.
     * EnumMap의 경우, Enum에 특화되어 만들어져있기 때문에 HashMap과 구현방식이 다르다.
     */
    System.out.println(Arrays.stream(garden)
      .collect(groupingBy(p -> p.lifeCycle)));

    System.out.println(Arrays.stream(garden)
      .collect(groupingBy(p -> p.lifeCycle,
        () -> new EnumMap<>(LifeCycle.class), toSet())));
  }
}
