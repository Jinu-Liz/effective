package practice.effective.chapter_06.item35.anti_pattern;

public enum Ensemble {
  SOLO,
  DUET,
  TRIO,
  QUARTET,
  QUINTET,
  SEXTET,
  SEPTET,
  OCTET,
  NONET,
  DECTET;

  /**
   * Enum은 상수가 정의되어 있는 위치를 반환하는 ordinal이라는 메서드를 제공.
   * 해당 메서드는 EnumSet과 EnumMap등 자바 내부에서 사용할 용도로 만들어진 것이며, 프로그래머가 사용할 용도로 만들어진 메서드가 아니다.
   * ordinal 메서드를 통해, 상수를 조작하려하는 것은 좋지 않다.
   * Enum에 정의하는 상수들의 순서가 바뀔 수 있고, 상수를 삭제하거나 추가할 수도 있기 때문.
   */
  public int numberOfMusicians() {
    return ordinal() + 1;
  }
}
