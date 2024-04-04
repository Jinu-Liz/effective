package practice.effective.chapter_04.item_31;

import practice.effective.chapter_04.item_31.example.Box;
import practice.effective.chapter_04.item_31.example.IntegerBox;

import java.util.Arrays;
import java.util.List;

public class Swap {

  /**
   * ? 는 불특정 타입이므로, 에러가 발생한다.
   * 어떤 타입인지 모르는 상태에서 막 넣으면 다른 타입이 섞일 수 있기 때문.
   *
   * ? 를 사용하면 타입을 중복으로 쓰지 않아 코드가 살짝 간편해질 수는 있으나
   * 값을 꺼내는 것밖에 할 수 없다. (null밖에 넣을 수 없다.)
   *
   * 따라서 ?를 사용할 때는, extends나 super를 같이 사용하여 타입을 한정지어 사용하는 것이 좋다.
   */
//  public static void swap(List<?> list, int i, int j) {
  public static <E> void swap(List<E> list, int i, int j) {
    list.set(i, list.set(j, list.get(i)));
  }

  /**
   * ? 를 굳이 사용하고 싶다면 swapHelper처럼 중복으로 만들어 타입을 지정해주어야한다.
   * 매우 비효율적.
   */
  public static void swap2(List<?> list, int i, int j) {
    swapHelper(list, i, j);
  }

  private static <E> void swapHelper(List<E> list, int i, int j) {
    list.set(i, list.set(j, list.get(i)));
  }

  public static void main(String[] args) {
    List<String> argList = Arrays.asList(args);
    swap(argList, 0, argList.size() - 1);
    System.out.println(argList);

    Box<Integer> myBox = new IntegerBox(10, "jinuliz");
    myBox.change(100);
  }
}
