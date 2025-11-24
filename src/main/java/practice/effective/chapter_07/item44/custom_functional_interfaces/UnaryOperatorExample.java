package practice.effective.chapter_07.item44.custom_functional_interfaces;

import com.google.common.base.Function;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

// 타입 1개를 인자로 받아, 해당 타입을 리턴
public class UnaryOperatorExample {
  public static void main(String[] args) {
    List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

    UnaryOperator<String> toUpperCase = String::toUpperCase;
    Function<String, String> toUpperCaseFunction = String::toUpperCase; // function으로도 가능
    List<String> upperCaseWords = names.stream()
      .map(toUpperCase)
      .toList();

    System.out.println("After conversion : " + upperCaseWords);
  }
}
