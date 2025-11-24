package practice.effective.chapter_07.item46;

import java.util.*;
import java.util.stream.Stream;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Freq {

  public static void main(String[] args) {
    Stream<String> words = Arrays.asList("book", "book", "the", "book").stream();

    /**
     * 스트림 패러다임을 이해하지 못한 채 API만 사용했다.
     * 외부의 값을 변경하고 있기 때문에 스트림을 제대로 사용했다고 보기 어렵다.
     * 이런 경우에는 사이드 이펙트가 발생할 수 있다.
     * 따라서 이렇게 쓰지 말 것!!
     */
    Map<String, Long> freq = new HashMap<>();
    words.forEach(word -> freq.merge(word.toLowerCase(), 1L, Long::sum));

    // 스트림을 제대로 활용하여 빈도표를 초기화 한다.
    Map<String, Long> collect = words.collect(groupingBy(String::toLowerCase, counting()));
    System.out.println(collect);

    List<String> topTen = collect.keySet().stream()
      .sorted(comparing(collect::get).reversed())
      .limit(10)
      .toList();

    System.out.println(topTen);

  }
}
