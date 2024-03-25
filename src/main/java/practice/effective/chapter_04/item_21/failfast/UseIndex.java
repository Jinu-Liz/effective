package practice.effective.chapter_04.item_21.failfast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UseIndex {
  public static void main(String[] args) {
    List<Integer> numbers = new ArrayList<>();
    numbers.add(1);
    numbers.add(2);
    numbers.add(3);
    numbers.add(4);
    numbers.add(5);

    /**
     * 인덱스를 사용하는 경우, 이터레이터 개념과 무관하므로 제거 가능하다.
      */
    for (int i = 0; i < numbers.size(); i++) {
      if (numbers.get(i) == 3) numbers.remove(numbers.get(i));
    }

    numbers.forEach(System.out::println);
  }
}
