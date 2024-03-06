package practice.effective.chapter_02.item_11.hashcode;

/**
 * equals를
 */
public class TraditionalHashCode {

  private final short areaCode, prefix, lineNum;

  public TraditionalHashCode(int areaCode, int prefix, int lineNum) {
    this.areaCode = rangeCheck(areaCode, 999, "area code");
    this.prefix = rangeCheck(prefix, 999, "prefix");
    this.lineNum = rangeCheck(lineNum, 9999, "line num");
  }

  private static short rangeCheck(int val, int max, String arg) {
    if (val < 0 || val > max) throw new IllegalArgumentException(arg + " : " + val);

    return (short) val;
  }

  /**
   * 전형적인 hashCode 메서드
   * 사전의 모든 단어를 해싱했었을 때, 31이라는 소수를 썼을 때 가장 충돌이 적었기 때문에 31을 씀.
   *
   */
  @Override
  public int hashCode() {
    int result = Short.hashCode(areaCode);  // 1
    result = 31 * result + Short.hashCode(prefix);  // 2
    result = 31 * result + Short.hashCode(lineNum);  // 3

    return result;
  }
}
