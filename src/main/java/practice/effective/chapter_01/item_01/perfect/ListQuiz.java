package practice.effective.chapter_01.item_01.perfect;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListQuiz {
  public static void main(String[] args) {
    List<Integer> numbers = new ArrayList<>();
    numbers.add(100);
    numbers.add(44);
    numbers.add(82);
    numbers.add(8);
    numbers.add(20);

    System.out.println(numbers);

    Comparator<Integer> desc = ((o1, o2) -> o2 - o1);
    numbers.sort(desc);
    System.out.println(numbers);

    // reversed를 사용해서 뒤집을 수 있음.
    numbers.sort(desc.reversed());
    System.out.println(numbers);
  }
}
