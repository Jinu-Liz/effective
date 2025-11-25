package practice.effective.chapter_07.item48.random;

import java.util.Random;
import java.util.SplittableRandom;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class RandomExample {

  public static void main(String[] args) {
    Random random = new Random();
    // random의 경우에 synchronized 되어 있기 때문에 멀티쓰레드 환경에서 느리다.
    System.out.println("random.nextInt(100) = " + random.nextInt(100));

    /**
     * 멀티쓰레드 환경에서는 성능 상 ThreadLocalRandom을 사용하는 것이 좋다.
     * 그러나, 병렬 처리 시에는 적합하지 않다.
     */
    int randomValue = ThreadLocalRandom.current().nextInt(100);
    System.out.println("randomValue = " + randomValue);

    /**
     * 병렬 처리할 수 있도록 분할될 수 있다.
     * 그러나, 멀티쓰레드 환경에서는 ThreadSafe하지 않다.
     */
    SplittableRandom splittableRandom = new SplittableRandom();
    IntStream randomIntStream = splittableRandom.ints(10, 0, 100);
    long count = randomIntStream
      .parallel()
      .filter(number -> number > 50)
      .count();

    System.out.println(count);
  }
}
