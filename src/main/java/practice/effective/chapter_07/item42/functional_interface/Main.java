package practice.effective.chapter_07.item42.functional_interface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static java.util.Comparator.comparingInt;

/**
 * JVM의 구현이 벤더사마다 다르기 때문에
 * 직렬화를 할 경우에는 해당 객체에서 람다 사용을 삼가하는게 좋다.
 */
public class Main {

  public static void main(String[] args) {
    ArrayList<String> words = new ArrayList<>(Arrays.asList("aaa", "bbbb", "c"));
    System.out.println(words);

    Collections.sort(words, (o1, o2) -> Integer.compare(o1.length(), o2.length()));

    Collections.sort(words, comparingInt(String::length));

    words.sort(comparingInt(String::length));

    System.out.println(words);
  }

  /**
   * 익명함수 내에서의 this는 익명함수를 가리키지만,
   * 람다에서 this는 사용 중인 클래스를 가리킨다.
   */
  public void checkThis() {
    new ArrayList<>().forEach(word -> System.out.println(this));
  }
}
