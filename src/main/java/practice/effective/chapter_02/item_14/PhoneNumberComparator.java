package practice.effective.chapter_02.item_14;

import lombok.Getter;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

@Getter
public final class PhoneNumberComparator implements Comparable<PhoneNumberComparator> {

  private final short areaCode, prefix, lineNum;

  public PhoneNumberComparator(int areaCode, int prefix, int lineNum) {
    this.areaCode = rangeCheck(areaCode, 999, "area code");
    this.prefix = rangeCheck(prefix, 999, "prefix");
    this.lineNum = rangeCheck(lineNum, 9999, "line num");
  }

  public PhoneNumberComparator(PhoneNumberComparator phoneNumber) {
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
  public PhoneNumberComparator clone() {
    try {
      return (PhoneNumberComparator) super.clone();
    } catch (CloneNotSupportedException e) {
      throw new AssertionError();
    }
  }

  /**
   * 비교자 생성 메서드를 활용한 비교자
   * Comparator의 static 메서드를 사용하여 COMPARATOR를 생성할 수 있다.
    */
  private static final Comparator<PhoneNumberComparator> COMPARATOR =
    Comparator.comparingInt(PhoneNumberComparator::getAreaCode)
      .thenComparingInt(PhoneNumberComparator::getPrefix)
      .thenComparingInt(PhoneNumberComparator::getLineNum);

  @Override
  public int compareTo(PhoneNumberComparator pn) {
    return COMPARATOR.compare(this, pn);
  }

  public static void main(String[] args) {
    PhoneNumberComparator pn = new PhoneNumberComparator(707, 867, 5309);
    Map<PhoneNumberComparator, String> map = new HashMap<>();
    map.put(pn, "제니");
    PhoneNumberComparator clone = pn.clone();
    System.out.println(map.get(clone));

    System.out.println(map.get(clone != pn));
    System.out.println(clone.getClass() == pn.getClass());
    System.out.println(clone.equals(pn));
  }
}
