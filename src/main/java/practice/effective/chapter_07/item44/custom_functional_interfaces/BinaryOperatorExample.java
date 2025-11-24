package practice.effective.chapter_07.item44.custom_functional_interfaces;

import java.util.function.BinaryOperator;

// 같은 타입 2개를 인자로 받아, 해당 타입을 리턴
public class BinaryOperatorExample {
  public static void main(String[] args) {
    BinaryOperator<String> concat = (s1, s2) -> s1 + s2;
    String result = concat.apply("Hello, ", "World!");

    System.out.println(result);
  }
}
