package practice.effective.chapter_07.item48.spliterator;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;

public class SpliteratorTrySplitExample {

  public static void main(String[] args) {
    List<String> list = Arrays.asList("apple", "banana", "cherry", "date", "elderberry", "fig", "grape");
    Spliterator<String> spliterator1 = list.spliterator();
    Spliterator<String> spliterator2 = spliterator1.trySplit(); // try가 붙은 메서드의 경우에 리턴 타입을 확인할 것.

    System.out.println("spliterator1");
    spliterator1.forEachRemaining(System.out::println);
    System.out.println("spliterator2");
    if (spliterator2 != null) spliterator2.forEachRemaining(System.out::println);
  }
}
