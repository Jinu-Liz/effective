package practice.effective.chapter_07.item43.method_reference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UnboundedMethodReference {

  public static void main(String[] args) {
    ArrayList<String> words = new ArrayList<>(Arrays.asList("Banana", "Apple", "Orange"));
    System.out.println("Before conversion : " + words);

    // 비한정적 메서드 참조 1
    List<String> lowerCaseWords = words.stream()
      .map(String::toLowerCase)
      .map(s -> s.toLowerCase())  // 첫번째 파라미터가 가진 메서드를 실행하는 개념
      .toList();

    System.out.println(lowerCaseWords);

    words = new ArrayList<>(Arrays.asList("banana", "apple", "orange"));
    System.out.println("Before sorting: " + words);

    // 비한정적 메서드 참조2
    // 첫번째 인자가 수신자가 되고, 다음 파라미터들이 매개변수가 된다.
    Collections.sort(words, String::compareTo);
//    Collections.sort(words, (s1, s2) -> s1.compareTo(s2));

    System.out.println("After sorting:  " + words);
  }
}
