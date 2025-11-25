package practice.effective.chapter_07.item48.spliterator;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;

public class SpliteratorCharacteristicsExample {

  public static void main(String[] args) {
    List<String> list = Arrays.asList("apple", "banana", "cherry", "date", "elderberry", "fig", "grape");
    Spliterator<String> spliterator = list.spliterator();

    int characteristics = spliterator.characteristics();
    System.out.println("characteristics = " + characteristics);
    System.out.println("Integer.toBinaryString(characteristics) = " + Integer.toBinaryString(characteristics));

    if ((characteristics & Spliterator.ORDERED) != 0) {
      System.out.println("list is ordered");
    }

    if ((characteristics & Spliterator.DISTINCT) != 0) {
      System.out.println("list is distinct");
    }

    if ((characteristics & Spliterator.SORTED) != 0) {
      System.out.println("list is sorted");
    }

    // 이렇게 쓰는 편이 가독성이 더 좋음
    if (spliterator.hasCharacteristics(Spliterator.SORTED)) {
      System.out.println("list is sorted");
    }
  }
}
