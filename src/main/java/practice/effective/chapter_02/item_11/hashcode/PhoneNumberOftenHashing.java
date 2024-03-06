package practice.effective.chapter_02.item_11.hashcode;

import java.util.Hashtable;

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
   *
   * volatile를 사용하면 가장 최근에 업데이트 된 값을 참조할 수 있다.
   */
  private volatile int hashCode;   // 자동으로 0으로 초기화된다.

  /**
   * Hashtable은 thread safety하기 때문에
   * synchronized를 사용한 코드를 별도로 작성하지 않아도 된다.
   */
  private Hashtable<PhoneNumberOftenHashing, String> phoneNumberOftenHashingStringHashtable;

  /**
   * synchronized를 사용하여 동기화를 해주면, 한 번에 하나의 쓰레드만 들어올 수 있다.
   * 대신, 메서드 단위로 synchronized를 걸면 성능의 저하가 생길 수 있다.
   *
   *
   */
  @Override
//  public synchronized int hashCode() {
  public int hashCode() {
    if (this.hashCode != 0) return hashCode;

    /**
     * 해당 블럭에만 동기화를 걸 수 있다.
     * 성능 저하를 최소화.
     */
    synchronized (this) {
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
}
