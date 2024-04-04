package practice.effective.chapter_04.item_31;

import practice.effective.chapter_04.item_31.example.IntegerBox;

import java.util.ArrayList;
import java.util.List;

public class RecursiveTypeBound {

  public static <E extends Comparable<? super E>> E max(List<? extends E> list) {
    if (list.isEmpty()) throw new IllegalArgumentException("빈 리스트");

    E result = null;
    for (E e : list) {
      if (result == null || e.compareTo(result) > 0) result = e;
    }

    return result;
  }

  public static void main(String[] args) {
    List<IntegerBox> list = new ArrayList<>();
    list.add(new IntegerBox(1, "jinuliz"));
    list.add(new IntegerBox(2, "liznuji"));

    System.out.println(max(list));
  }
}
