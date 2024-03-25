package practice.effective.chapter_04.item_21.failfast;

import java.util.ArrayList;
import java.util.List;

public class FailFast {
  public static void main(String[] args) {
    /**
     * List.of로 생성 시, 불변 객체를 생성하기 때문에 변경이 불가하다.
     */
//    List<Integer> numbers = List.of(1, 2, 3, 4, 5);

    List<Integer> numbers = new ArrayList<>();
    numbers.add(1);
    numbers.add(2);
    numbers.add(3);
    numbers.add(4);
    numbers.add(5);

    /**
     * 이터레이터로 콜렉션을 순회하는 중에 Collection의 remover를 사용한다면?
     *
     * 이터레이터 순회 중에 변경이 발생된다면 예외가 발생할 수 있다.
     * 이터레이터가 알지 못하게 컬렉션에서 변경이 일어났기 때문이다.
      */
    for (Integer number : numbers) {
      if (number == 3) {
        numbers.remove(number);
      }
    }
  }
}
