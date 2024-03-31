package practice.effective.chapter_04.item_28.array_to_list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ChooserArrayAfter<T> {

  private final List<T> choiceList;

  public ChooserArrayAfter(Collection<T> choices) {
    this.choiceList = new ArrayList<>(choices);
  }

  public T choose() {
    Random rnd = ThreadLocalRandom.current();

    return this.choiceList.get(rnd.nextInt(this.choiceList.size()));
  }

  public static void main(String[] args) {
    List<Integer> intList = List.of(1, 2, 3, 4, 5);
    ChooserArrayAfter<Integer> chooser = new ChooserArrayAfter<>(intList);

    for (int i = 0; i < 10; i++) {
      Number choice = chooser.choose();
      System.out.println(choice);
    }

    List<String> strList = List.of("jinuliz", "hyony", "sejong", "potata");
    ChooserArrayAfter<String> chooserStr = new ChooserArrayAfter<>(strList);

    for (int i = 0; i < 10; i++) {
      String choice = chooserStr.choose();
      System.out.println(choice);
    }
  }
}
