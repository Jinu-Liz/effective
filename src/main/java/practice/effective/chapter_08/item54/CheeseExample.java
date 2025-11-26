package practice.effective.chapter_08.item54;

import java.util.List;

public class CheeseExample {

  public static void main(String[] args) {
    CheeseStore store = new CheeseStore(null);
    List<Cheese> cheeses = store.getCheese();
    if (cheeses != null && !cheeses.isEmpty()) {
      System.out.println(cheeses.size());
    } else {
      System.out.println("no cheese");
    }
  }
}
