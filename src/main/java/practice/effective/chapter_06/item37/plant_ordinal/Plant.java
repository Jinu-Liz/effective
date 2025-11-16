package practice.effective.chapter_06.item37.plant_ordinal;

import java.util.HashSet;
import java.util.Set;

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

  /**
   * 배열은 제네릭과 호환되지 않아 깔끔하게 컴파일이 되지 않는다.
   * 배열은 각 인덱스의 의미를 모르니 출력 결과에 직접 레이블을 달아야 한다.
   * 가장 심각한 것은, 정확한 정숫값을 사용한다는 것이 보증되지 않는다는 점이다.
   * 정수는 열거 타입과 달리 타입 안전하지 않기 때문에 잘못된 값을 사용할 시에도 동작한다.
   */
  public static void main(String[] args) {
    Plant[] garden = {
      new Plant("바질", LifeCycle.ANNUAL),
      new Plant("캐러웨이", LifeCycle.BIENNIAL),
      new Plant("딜", LifeCycle.ANNUAL),
      new Plant("라벤더", LifeCycle.PERENNIAL),
      new Plant("파슬리", LifeCycle.BIENNIAL),
      new Plant("로즈마리", LifeCycle.PERENNIAL)
    };

    // ordinal()을 배열 인덱스로 사용.
    Set<Plant>[] plantByLifeCycleArr = (Set<Plant>[]) new Set[LifeCycle.values().length];
    for (int i = 0; i < plantByLifeCycleArr.length; i++) {
      plantByLifeCycleArr[i] = new HashSet<>();
    }

    for (Plant plant : garden) {
      plantByLifeCycleArr[plant.lifeCycle.ordinal()].add(plant);
    }

    for (int i = 0; i < plantByLifeCycleArr.length; i++) {
      System.out.printf("%s: %s%n", LifeCycle.values()[i], plantByLifeCycleArr[i]);
    }
  }
}
