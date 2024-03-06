package practice.effective.chapter_02.item_11.hashcode;

public final class PhoneNumberOftenHashing {

  private final short areaCode, prefix, lineNum;

  public PhoneNumberOftenHashing(int areaCode, int prefix, int lineNum) {
    this.areaCode = rangeCheck(areaCode, 999, "area code");
    this.prefix = rangeCheck(prefix, 999, "prefix");
    this.lineNum = rangeCheck(lineNum, 9999, "line num");
  }

  private static short rangeCheck(int val, int max, String arg) {
    if (val < 0 || val > max) throw new IllegalArgumentException(arg + " : " + val);

    return (short) val;
  }

  /**
   * 해시코드를 지연 초기화하는 hashCode 메서드.
   * 스레드 안정성까지 고려해야 한다.
   * 여러 스레드가 서로 엇갈리며 계산하면서 각각 다른 값이 나올 수 있기 때문.
   *
   * 객체가 불변인 경우, 자주 해싱을 해야할 때 해시코드를 캐싱하여 재사용한다.
   */
  private int hashCode;   // 자동으로 0으로 초기화된다.

  @Override
  public int hashCode() {
    int result = hashCode;
    if (result == 0) {
      result = Short.hashCode(areaCode);
      result = 31 * result + Short.hashCode(prefix);
      result = 31 * result + Short.hashCode(lineNum);
      hashCode = result;
    }

    return result;
  }
}
