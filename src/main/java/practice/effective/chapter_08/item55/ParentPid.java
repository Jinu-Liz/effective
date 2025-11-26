package practice.effective.chapter_08.item55;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Stream;

/**
 * Optional은 사용자에게 값이 없음을 알려주는 수단.
 * 이에 대한 처리를 요할 수 있다.
 *
 * Collection, 배열, Optional, Stream
 * 등을 Optional로 감싸 처리할 필요가 없다.
 * 자체적으로 빈값 처리가 가능하기 때문에 불필요.
 */
public class ParentPid {

  public static void main(String[] args) {
    ProcessHandle ph = ProcessHandle.current();

    // isPresent를 적절치 못하게 사용했다.
    Optional<ProcessHandle> parentProcess = ph.parent();
    System.out.println("부모 PID: " + (parentProcess.isPresent() ?
      String.valueOf(parentProcess.get().pid()) : "N/A"));

    // 같은 기능을 Optional의 map을 이용하여 개선
    System.out.println("부모 PID: " +
      ph.parent()
        .map(h -> String.valueOf(h.pid())).orElse("N/A"));

    // Optional의 스트림
    Stream<Optional<String>> streamOfOptionals = Stream.of(
      Optional.of("A"),
      Optional.empty(),
      Optional.of("C"),
      Optional.of("D"),
      Optional.empty()
    );

    // isPresent를 적절치 못하게 사용했다.
    streamOfOptionals
      .filter(Optional::isPresent)
      .map(Optional::get)
      .forEach(System.out::println);

    // 같은 기능을 Optional의 스트림을 이용하여 개선한 코드. flatMap을 사용하면 값이 있는 Optional을 모아 스트림으로 반환.
    streamOfOptionals.flatMap(Optional::stream)
      .forEach(System.out::println);

    int i = 20;
    Optional<Integer> optional = Optional.of(i);  // int -> Integer -> Optional<Integer> / Boxing이 2번 된다.
    OptionalInt.of(i);  // OptionalInt를 사용하면 Boxing 1번만 하면 된다.
  }
}
