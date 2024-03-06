package practice.effective.chapter_02.item_11.hashcode;

public class PhoneNumber {

  private final short areaCode, prefix, lineNum;

  public PhoneNumber(int areaCode, int prefix, int lineNum) {
    this.areaCode = rangeCheck(areaCode, 999, "area code");
    this.prefix = rangeCheck(prefix, 999, "prefix");
    this.lineNum = rangeCheck(lineNum, 9999, "line num");
  }

  private static short rangeCheck(int val, int max, String arg) {
    if (val < 0 || val > max) throw new IllegalArgumentException(arg + " : " + val);

    return (short) val;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;

    if (!(o instanceof PhoneNumber)) return false;

    PhoneNumber pn = (PhoneNumber) o;
    return areaCode == pn.areaCode && prefix == pn.prefix && lineNum == pn.lineNum;
  }

  @Override
  public int hashCode() {
    return 42;
  }
}
