package practice.effective.chapter_04.item_28.array_to_list;

import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ChooserArray {

  private final Object[] choiceList;

  public ChooserArray(Collection choices) {
    this.choiceList = choices.toArray();
  }

  public Object choose() {
    Random rnd = ThreadLocalRandom.current();

    return choiceList[rnd.nextInt(choiceList.length)];
  }

  public static void main(String[] args) {
    List<Integer> intList = List.of(1, 2, 3, 4, 5);
    ChooserArray chooser = new ChooserArray(intList);

    for (int i = 0; i < 10; i++) {
      Number choice = (Number) chooser.choose();
      System.out.println(choice);
    }
  }
}
