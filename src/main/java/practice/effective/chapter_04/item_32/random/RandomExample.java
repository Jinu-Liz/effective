package practice.effective.chapter_04.item_32.random;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomExample {

  private int value;

  public synchronized int compareAndSwap(int expectedValue, int newValue) {
    int readValue = this.value;
    if (readValue == expectedValue) this.value = newValue;

    return readValue;
  }

  /**
   * Atomic이 붙은 타입의 경우, 사용할 때 Lock을 건다.
   *
   * 동시에 여러 Thread가 많이 호출되면서 nextInt를 호출하는 경우, Random은 실패하는 경우가 있다.
   * 그럴 경우에는 ThreadLocalRandom을 사용하는 것이 안전하다.
   */
  public static void main(String[] args) {
    Random random = new Random();
    System.out.println(random.nextInt(10));

    ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
    System.out.println(threadLocalRandom.nextInt(10));
  }
}
