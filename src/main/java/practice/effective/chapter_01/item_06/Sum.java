package practice.effective.chapter_01.item_06;

public class Sum {

  /**
   * long -> Long타입으로 오토박싱 / 언박싱이 일어난다.
   * 이 과정에서 불필요하게 객체를 만들게 되면서 비용이 발생한다.
   *
   * Long을 primitive 타입인 long으로 바꾸어 계산하면
   * 불필요한 비용이 줄어 훨씬 빠르다.
   */
  private static long sum() {
    Long sum = 0L;
    for (long i = 0; i <= Integer.MAX_VALUE; i++) {
      sum += i;
    }
    return sum;
  }

  public static void main(String[] args) {
    long start = System.nanoTime();
    long x = sum();
    long end = System.nanoTime();

    System.out.println((end - start) / 1_000_000. + " ms.");
    System.out.println(x);
  }
}
