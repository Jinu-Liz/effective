package practice.effective.chapter_02.item_13.treeset;

import java.util.TreeSet;

public class TreeSetExample {

  public static void main(String[] args) {
    TreeSet<Integer> numbers = new TreeSet<>();
    numbers.add(10);
    numbers.add(4);
    numbers.add(6);

    for (Integer number : numbers) {
      System.out.println(number);
    }
  }
}
