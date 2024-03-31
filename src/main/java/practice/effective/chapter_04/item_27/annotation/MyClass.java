package practice.effective.chapter_04.item_27.annotation;

import java.util.Arrays;

@MyAnnotation
public class MyClass {

  public static void main(String[] args) {
    Arrays.stream(MyClass.class.getAnnotations())
      .forEach(System.out::println);
  }
}
