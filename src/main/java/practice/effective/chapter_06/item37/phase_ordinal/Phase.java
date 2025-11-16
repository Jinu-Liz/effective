package practice.effective.chapter_06.item37.phase_ordinal;

import static practice.effective.chapter_06.item37.phase_ordinal.Phase.Transition.*;

// 중첩 EnumMap으로 데이터와 열거 타입 쌍을 연결
public enum Phase {

  SOLID, LIQUID, GAS;

  public enum Transition {
    MELT, FREEZE, BOIL, CONDENSE, SUBLIME, DEPOSIT;
  }

  private static final Transition[][] TRANSITIONS = {
    { null, MELT, SUBLIME },
    { FREEZE, null, BOIL },
    { DEPOSIT, CONDENSE, null }
  };

  public static Transition from(Phase from, Phase to) {
    return TRANSITIONS[from.ordinal()][to.ordinal()];
  }

}
