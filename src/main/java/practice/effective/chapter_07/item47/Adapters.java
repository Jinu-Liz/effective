package practice.effective.chapter_07.item47;

import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Stream <-> Iterable 직접 변경이 불가능하기 때문에 어댑터를 따로 구성해야한다.
 * 따라서, 둘 다 사용가능한 Collection을 사용하는 것이 낫다.
 */
public class Adapters {

  // Stream을 Iterable로 중개해주는 어댑터
  public static <E> Iterable<E> iterableOf(Stream<E> stream) {
    return stream::iterator;
  }

  // Iterable을 Stream으로 중개해주는 어댑터
  public static <E> Stream<E> streamOf(Iterable<E> iterable) {
    return StreamSupport.stream(iterable.spliterator(), false);
  }

  public static void main(String[] args) {
    List<String> names = List.of("Alice", "Bob", "Charlie");

    // 리스트(컬렉션)을 스트림으로 변환
    Stream<String> stream = names.stream();

    // 어댑터를 사용하여 스트림을 이터러블로 변환
    Iterable<String> iterable = Adapters.iterableOf(stream);
    System.out.println("Iterable from Stream");
    for (String s : iterable) {
      System.out.println(s);
    }

    Stream<String> streamFromIterable = Adapters.streamOf(iterable);
    System.out.println("Stream from Iterable");
    streamFromIterable.forEach(System.out::println);

  }
}
