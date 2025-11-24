package practice.effective.chapter_07.item44.custom_functional_interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

// 인자와 리턴의 타입이 다른 경우
public class FunctionalExample {
  public static void main(String[] args) {
    List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
    Function<String, Integer> stringLength = String::length;
    List<Integer> lengths = names.stream()
      .map(stringLength)
      .toList();

    System.out.println(lengths);
  }
}
