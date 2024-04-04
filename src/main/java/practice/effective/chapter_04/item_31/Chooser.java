package practice.effective.chapter_04.item_31;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class Chooser<T> {

  private final List<T> choiceList;

  private final Random rnd = new Random();

  /**
   * T 생산자 매개변수에 와일드카드 타입 적용
   */
  public Chooser(Collection<? extends T> choices) {
    this.choiceList = new ArrayList<>(choices);
  }

  public T choose() {
    return this.choiceList.get(rnd.nextInt(this.choiceList.size()));
  }

  public static void main(String[] args) {
    List<Integer> intList = List.of(1, 2, 3, 4, 5, 6);
    Chooser<Number> chooser = new Chooser<>(intList);   // 와일드 카드 적용으로 Integer타입 가능
    for (int i = 0; i < 10; i++) {
      Number choice = chooser.choose();
      System.out.println(choice);
    }
  }
}
