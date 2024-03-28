package practice.effective.chapter_04.item_26.terms;

import java.util.ArrayList;
import java.util.List;

public class GenericBasic {
  public static void main(String[] args) {
    /**
     * Generic 사용하기 전
     * 타입을 지정하지 않은 Raw 타입이기 때문에
     * 모든 타입들이 들어갈 수 있다. (Object를 받게 됨)
     *
     * 컴파일 타임에 에러를 찾기 어렵고, 런타임에 에러가 발생한다.
      */
    List numbers = new ArrayList<>();
    numbers.add(10);
    numbers.add("jinuliz");

    for (Object number : numbers) {
      System.out.println((Integer) number);
    }
  }
}
