package practice.effective.chapter_07.item42.anonymous_class;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {

  public static void main(String[] args) {
    ArrayList<String> words = new ArrayList<>(Arrays.asList("aaa", "bbbb", "c"));
    System.out.println(words);

    Collections.sort(words, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return Integer.compare(o1.length(), o2.length());
      }
    });

    System.out.println(words);
  }
}
