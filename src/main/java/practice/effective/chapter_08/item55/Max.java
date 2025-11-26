package practice.effective.chapter_08.item55;

import java.util.*;

public class Max {

  /**
   * 컬렉션에서 최댓값을 구함. 컬렉션이 비었으면 예외를 던진다.
   * 해당 메서드를 사용하는 쪽에서는 null처리를 신경써야하고,
   * 어떤 예외가 어떤 상황에 발생하는지 알아야하는 번거로움이 있다.
    */
  public static <E extends Comparable<E>> E max(Collection<E> c) {
    if (c.isEmpty()) throw new IllegalArgumentException("Empty collection");

    E result = null;
    for(E e : c) {
      if (result == null || e.compareTo(result) > 0) result = Objects.requireNonNull(e);
    }

    return result;
  }

  /**
   * 사용하는 쪽에서는 리턴 타입을 보고 null이 반환될 수 있다는 것을 알 수 있다.
   */
  public static <E extends Comparable<E>> Optional<E> optionalMax(Collection<E> c) {
    if (c.isEmpty()) return Optional.empty();

    E result = null;
    for(E e : c) {
      if (result == null || e.compareTo(result) > 0) result = Objects.requireNonNull(e);
    }

    return Optional.of(result);
  }

  // 스트림 버전
  public static <E extends Comparable<E>> Optional<E> streamMax(Collection<E> c) {
    return c.stream().max(Comparator.naturalOrder());
  }

  public static void main(String[] args) {
    List<String> words = List.of("hello", "world");

    // optional에서 제공하는 메서드를 통해 가독성 좋게 처리 가능
    Optional<String> max = optionalMax(words);
    max.ifPresent(System.out::println);
    max.orElseThrow(IllegalArgumentException::new);

    // 기본값을 정해둘 수 있다.
    String lastWordInLexicon = max.orElse("단어 없음");
    System.out.println("lastWordInLexicon = " + lastWordInLexicon);
  }
}
