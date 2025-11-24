package practice.effective.chapter_07.item44.custom_functional_interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

// Boolean을 반환하는 함수
public class PredicateExample {
  public static void main(String[] args) {
    List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

    Predicate<String> startsWithB = s -> s.startsWith("B");
    List<String> filteredNames = names.stream()
      .filter(startsWithB)
      .toList();

    System.out.println("Filtered : " + filteredNames);
  }
}
