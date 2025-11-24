package practice.effective.chapter_07.item44.custom_functional_interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;

// 인자 없이 리턴만 있는 경우
public class ConsumerExample {
  public static void main(String[] args) {
    List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
    Consumer<String> printer = System.out::println;
    names.forEach(printer);
  }
}
