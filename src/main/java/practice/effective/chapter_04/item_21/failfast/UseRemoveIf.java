package practice.effective.chapter_04.item_21.failfast;

import java.util.ArrayList;
import java.util.List;

public class UseRemoveIf {
  public static void main(String[] args) {
    List<Integer> numbers = new ArrayList<>();
    numbers.add(1);
    numbers.add(2);
    numbers.add(3);
    numbers.add(4);
    numbers.add(5);

    /**
     * removeIf의 경우, Iterator를 직접 사용하는 것과 동일하다.
      */
    numbers.removeIf(number -> number == 3);
    numbers.forEach(System.out::println);
  }
}
