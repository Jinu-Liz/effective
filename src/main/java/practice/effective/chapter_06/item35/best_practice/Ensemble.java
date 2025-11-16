package practice.effective.chapter_06.item35.best_practice;

/**
 * ordinal을 사용하지 않고, 필드와 메서드를 정의하여 사용.
 */
public enum Ensemble {
  SOLO(1),
  DUET(2),
  TRIO(3),
  QUARTET(4),
  QUINTET(5),
  SEXTET(6),
  SEPTET(7),
  OCTET(8),
  NONET(9),
  DECTET(10);

  private final int numberOfMusicians;

  Ensemble(int size) {
    this.numberOfMusicians = size;
  }

  public int numberOfMusicians() {
    return numberOfMusicians;
  }
}
