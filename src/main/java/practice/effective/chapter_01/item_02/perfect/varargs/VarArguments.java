package practice.effective.chapter_01.item_02.perfect.varargs;

import java.util.Arrays;

public class VarArguments {

  /**
   * 가변 인수의 경우, 하나의 메서드에 한 개만 사용할 수 있다.
   * 이를 Builder의 값을 셋팅하는 메서드마다 하나씩 사용하면
   * 메서드 체이닝을 쓰면서 마치 가변인수를 여러 개 쓰는 것처럼 사용할 수 있다.
   */
  public void printNumbers(int... numbers) {
    System.out.println(numbers.getClass().getCanonicalName());
    System.out.println(numbers.getClass().getComponentType());
    Arrays.stream(numbers).forEach(System.out::println);
  }

  public static void main(String[] args) {
    VarArguments varArguments = new VarArguments();
    varArguments.printNumbers(1, 20, 20, 39, 59);
  }
}
