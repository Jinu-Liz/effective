package practice.effective.chapter_04.item_26.term;

import java.util.ArrayList;
import java.util.List;

public class GenericBasicAfter {
  public static void main(String[] args) {
    /**
     * 타입을 지정해주어 타입이 다를 경우,
     * 컴파일 타임에 에러를 발생시킬 수 있다.
      */
    List<Integer> numbers = new ArrayList<>();
    numbers.add(10);
//    numbers.add("jinuliz");

    for (Object number : numbers) {
      System.out.println((Integer) number);
    }
  }
}
