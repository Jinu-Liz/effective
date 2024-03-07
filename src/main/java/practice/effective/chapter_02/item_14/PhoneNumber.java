package practice.effective.chapter_02.item_14;

import java.util.HashMap;
import java.util.Map;

public final class PhoneNumber implements Comparable<PhoneNumber> {

  private final short areaCode, prefix, lineNum;

  public PhoneNumber(int areaCode, int prefix, int lineNum) {
    this.areaCode = rangeCheck(areaCode, 999, "area code");
    this.prefix = rangeCheck(prefix, 999, "prefix");
    this.lineNum = rangeCheck(lineNum, 9999, "line num");
  }

  public PhoneNumber(PhoneNumber phoneNumber) {
    this(phoneNumber.areaCode, phoneNumber.prefix, phoneNumber.lineNum);
  }

  private static short rangeCheck(int val, int max, String arg) {
    if (val < 0 || val > max) throw new IllegalArgumentException(arg + " : " + val);

    return (short) val;
  }

  @Override
  public int hashCode() {
    int result = Short.hashCode(areaCode);
    result = 31 * result + Short.hashCode(prefix);
    result = 31 * result + Short.hashCode(lineNum);

    return result;
  }

  @Override
  public PhoneNumber clone() {
    try {
      return (PhoneNumber) super.clone();
    } catch (CloneNotSupportedException e) {
      throw new AssertionError();
    }
  }

  // 기본 타입 필드가 여럿일 때의 비교자
  @Override
  public int compareTo(PhoneNumber pn) {
    int result = Short.compare(areaCode, pn.areaCode);
    if (result == 0) {
      result = Short.compare(prefix, pn.prefix);

      if (result == 0) result = Short.compare(lineNum, pn.lineNum);
    }

    return result;
  }

  public static void main(String[] args) {
    PhoneNumber pn = new PhoneNumber(707, 867, 5309);
    Map<PhoneNumber, String> map = new HashMap<>();
    map.put(pn, "제니");
    PhoneNumber clone = pn.clone();
    System.out.println(map.get(clone));

    System.out.println(map.get(clone != pn));
    System.out.println(clone.getClass() == pn.getClass());
    System.out.println(clone.equals(pn));
  }
}
