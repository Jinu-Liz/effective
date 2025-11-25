package practice.effective.chapter_07.item48;

import java.math.BigInteger;
import java.util.stream.LongStream;

// 병렬화 사용의 좋은 예시
public class ParallelPrimeCounting {

  static long pi(long n) {
    return LongStream.rangeClosed(2, n)
      .parallel()
      .mapToObj(BigInteger::valueOf)
      .filter(i -> i.isProbablePrime(50))
      .count();
  }

  public static void main(String[] args) {
    System.out.println(pi(10_000_000));
  }
}
