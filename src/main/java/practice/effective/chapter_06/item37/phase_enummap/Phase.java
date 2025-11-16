package practice.effective.chapter_06.item37.phase_enummap;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

// 중첩 EnumMap으로 데이터와 열거 타입 쌍을 연결
public enum Phase {

  SOLID, LIQUID, GAS;

  public enum Transition {
    MELT(SOLID, LIQUID),
    FREEZE(LIQUID, SOLID),
    BOIL(LIQUID, GAS),
    CONDENSE(GAS, LIQUID),
    SUBLIME(SOLID, GAS),
    DEPOSIT(GAS, SOLID);

    private final Phase from;

    private final Phase to;

    Transition(Phase from, Phase to) {
      this.from = from;
      this.to = to;
    }

    // stream을 사용하지 않은 코드
    private static final Map<Phase, Map<Phase, Transition>> map = new EnumMap<>(Phase.class);
    static {
      for (Transition transition : Transition.values()) {
        map.computeIfAbsent(
          transition.from,
          k -> new EnumMap<>(Phase.class)
        ).put(transition.to, transition);
      }
    }

    private static final Map<Phase, Map<Phase, Transition>> m =
      Stream.of(values())
        .collect(groupingBy(
          t -> t.from,
          () -> new EnumMap<>(Phase.class),
          toMap(
            t -> t.to,
            t -> t,
            (x, y) -> y,
            () -> new EnumMap<>(Phase.class)
          )
        ));

    public static Transition from(Phase from, Phase to) {
      return m.get(from).get(to);
    }
  }
}
