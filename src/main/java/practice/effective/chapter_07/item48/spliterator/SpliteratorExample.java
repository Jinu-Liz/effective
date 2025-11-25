package practice.effective.chapter_07.item48.spliterator;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;

public class SpliteratorExample {

  public static void main(String[] args) {
    List<String> list = Arrays.asList("apple", "banana", "cherry", "date", "elderberry", "fig", "grape");
    Spliterator<String> spliterator = list.spliterator();

    // 하나만 실행해 봄
    System.out.println("tryAdvance");
    spliterator.tryAdvance(System.out::println);

    // 나머지에 실행
    System.out.println("forEachRemaining");
    spliterator.forEachRemaining(System.out::println);
  }
}
