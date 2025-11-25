package practice.effective.chapter_07.item48;

import java.math.BigInteger;
import java.util.stream.Stream;

import static java.math.BigInteger.*;

/**
 * 병렬 스트림을 사용하여 메르센 소수를 생성하는 프로그램
 * 메르센 소수 : n이 소수일 떄, 2^n - 1도 소수가 되는 수
 *
 * 병렬화를 통해 성능 향상을 기대할 수 없는 경우
 * 데이터 소스: Stream.iterate()
 * -> 앞의 값이 계산되어야만 다음 값 생성이 가능하다.
 * 즉, 내부적으로 stateful하고, 병렬로 분할하기 어려운 구조.
 *
 * 중간 연산: limit()
 * -> 먼저 오는 요소를 n개 모아야하기 때문에, 순서 보존을 강제한다. Encounter order(기존 데이터 요소의 순서) 사용.
 * 따라서, 병렬로 데이터를 가져와도 결국 앞선 요소를 기다리게 되어 병렬 이점이 사라짐.
 * 다만, unordered()를 같이 사용하면 순서를 포기하여 병렬 이점을 얻을 수 있다.
 *
 * 종단 연산: collect()
 * -> 순서 보존을 요구할 수 있다. 특히, toList()는 Encounter order(기존 데이터 요소의 순서)를 보존한다.
 * 때문에 병렬로 생성하더라도 결과를 다시 순서대로 정렬해서 병합해야 한다.
 *
 * 병렬화 사용 시에는 반드시 성능 체크를 해야한다.
 * 운영과 비슷한 양의 데이터를 가지고 성능 체크 할 것.
 */
public class ParallelMersennePrimes {

  // 주의: 병렬화의 영향으로 프로그램이 종료되지 않는다.
  public static void main(String[] args) {
    primes()
      .map(p -> TWO.pow(p.intValueExact()).subtract(ONE))
      .parallel()
      .filter(mp -> mp.isProbablePrime(50))
      .limit(20)
      .forEach(System.out::println);
  }

  static Stream<BigInteger> primes() {
    return Stream.iterate(TWO, BigInteger::nextProbablePrime);
  }
}
