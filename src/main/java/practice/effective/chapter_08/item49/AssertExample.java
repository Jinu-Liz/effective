package practice.effective.chapter_08.item49;

/**
 * assert라는 게 있음
 * 근데 실제 검증로직을 구현하는게 더 낫다고 생각.
 */
public class AssertExample {

  public static void main(String[] args) {
    doPrivate();
  }

  private static void doPrivate() {
    int value = 5;

    assert value > 0 : "Value should be greater than zero.";

    value = -5;

    assert value > 0 : "Value should be greater than zero.";
  }
}
