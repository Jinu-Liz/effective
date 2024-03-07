package practice.effective.chapter_02.item_12;

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

  /**
   * 이 전화번호의 문자열 표현을 반환.
   * "XXX-YYY-ZZZZ" 형태의 12글자로 구성된다.
   * XXX는 지역코드, YYY는 프리픽스, ZZZ는 가입자 번호다.
   * 각각의 대문자는 10진수 숫자 하나를 나타낸다.
   *
   * 전화번호의 각 부분의 값이 너무 작아서 자릴수를 채울 수 없다면,
   * 앞에서부터 0으로 채워나간다. 예컨대 가입자 번호가 123이라면
   * 전화번호의 마지막 네 문자는 "0123"이 된다.
   *
   * 공개할 수 있는 정보만 사용하도록 한다.
   */
  @Override
  public String toString() {
    return String.format("%03d-%03d-%04d", areaCode, prefix, lineNum);
  }

  /**
   * toString에서 공개된 정보를 제공하니,
   * 이를 구성하는 데이터를 따로 제공하는 메서드를 작성하라.
   */
  public short getAreaCode() {
    return areaCode;
  }

  public short getPrefix() {
    return prefix;
  }

  public short getLineNum() {
    return lineNum;
  }

  /**
   * 정적 팩토리 패턴으로 사용 시
   */
  public static PhoneNumber of(String phoneNumberString) {
    String[] split = phoneNumberString.split("-");
    PhoneNumber phoneNumber = new PhoneNumber(
      Integer.parseInt(split[0]),
      Integer.parseInt(split[1]),
      Integer.parseInt(split[2])
    );

    return phoneNumber;
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
    int result = Short.hashCode(areaCode);
    result = 31 * result + Short.hashCode(prefix);
    result = 31 * result + Short.hashCode(lineNum);

    return result;
  }

  public static void main(String[] args) {
    PhoneNumber jenny = new PhoneNumber(707, 867, 5309);
    System.out.println("제니의 번호 : " + jenny);

    PhoneNumber phoneNumber = PhoneNumber.of("707-867-5309");
    System.out.println(phoneNumber);
    System.out.println(jenny.equals(phoneNumber));
    System.out.println(jenny.hashCode() == phoneNumber.hashCode());
  }
}
