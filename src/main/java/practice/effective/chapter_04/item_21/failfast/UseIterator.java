package practice.effective.chapter_04.item_21.failfast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UseIterator {
  public static void main(String[] args) {
    List<Integer> numbers = new ArrayList<>();
    numbers.add(1);
    numbers.add(2);
    numbers.add(3);
    numbers.add(4);
    numbers.add(5);

    /**
     * 이터레이터를 직접 순회하면, 도중에 값을 제거할 수 있다.
      */
    for (Iterator<Integer> iterator = numbers.iterator(); iterator.hasNext();) {
      Integer integer = iterator.next();
        if (integer == 3) iterator.remove();
    }

    numbers.forEach(System.out::println);
  }
}
