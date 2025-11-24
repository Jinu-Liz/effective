package practice.effective.chapter_07.item44.standard_functional_interfaces;

public class TriFunctionExample {

  public static void main(String[] args) {
    TriFunction<String, String, String, String> concat = (s1, s2, s3) -> s1 + s2 + s3;

    String result = concat.apply("Hello, ", ">< ", "World!");
    System.out.println("result = " + result);

    TriFunction<Integer, Integer, Integer, Integer> sum = (a, b, c) -> a + b + c;
    Integer sumResult = sum.apply(1, 2, 3);
    System.out.println("sumResult = " + sumResult);
  }


}
