package practice.effective.chapter_01.item_02.builder.hierarchy;

import static practice.effective.chapter_01.item_02.builder.hierarchy.Pizza.Topping.*;

public class PizzaMain {
  public static void main(String[] args) {
    NyPizza pizza = new NyPizza.Builder(NyPizza.Size.SMALL)
      .addTopping(SAUSAGE)
      .addTopping(ONION)
      .build();
  }

  Calzone calzone = new Calzone.Builder()
    .addTopping(HAM)
    .sauceInside()
    .build();
}
