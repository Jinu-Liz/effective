package practice.effective.chapter_02.item_13;

import java.util.HashMap;
import java.util.Map;

public final class PhoneNumber {

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
  public int hashCode() {
    int result = Short.hashCode(areaCode);
    result = 31 * result + Short.hashCode(prefix);
    result = 31 * result + Short.hashCode(lineNum);

    return result;
  }

  /**
   * 가변 상태를 참조하지 않는 클래스용 clone 메서드
   *
   * Object의 하위 클래스들이 오버라이딩 할 수 있다.
   * 더 구체적인 타입으로 만들어, 타입캐스팅하지 않아도 될 수 있도록 하는 것이 좋다.
    */
  @Override
  public PhoneNumber clone() {
    try {
      /**
       * super.clone을 사용하지 않고
       * 생성자를 자체적으로 리턴할 경우,하위 클래스의 clone이 깨질 수 있다.
       */
      return (PhoneNumber) super.clone();
    } catch (CloneNotSupportedException e) {
      throw new AssertionError();   // 일어날 수 없는 일이다.
    }
  }

  public static void main(String[] args) {
    PhoneNumber pn = new PhoneNumber(707, 867, 5309);
    Map<PhoneNumber, String> map = new HashMap<>();
    map.put(pn, "제니");
    PhoneNumber clone = pn.clone();
    System.out.println(map.get(clone));

    System.out.println(map.get(clone != pn));   // 반드시 true
    System.out.println(clone.getClass() == pn.getClass());    // 반드시 true
    System.out.println(clone.equals(pn));   // true가 아닐 수도 있다.
  }
}
