package practice.effective.chapter_07.item43.method_reference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class StaticMethodReference {

  public static void main(String[] args) {
    ArrayList<String> words = new ArrayList<>(Arrays.asList("aaa", "bbbbb", "c"));
    System.out.println("Before sorting: " + words);

    // 정적 메서드 참조
    Collections.sort(words, StaticMethodReference::compareByLength);

    System.out.println("After sorting:  " + words);
  }

  public static int compareByLength(String a, String b) {
    return Integer.compare(a.length(), b.length());
  }
}
