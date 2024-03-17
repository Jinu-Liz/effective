package practice.effective.chapter_04.item_17.part3;

import java.math.BigInteger;

public class BigIntegerUtils {

  /**
   * 재정의가 가능한 클래스는 방어적인 복사를 사용해야 한다.
   */
  public static BigInteger safeInstance(BigInteger val) {
    return val.getClass() == BigInteger.class ? val : new BigInteger(val.toByteArray());
  }
}
