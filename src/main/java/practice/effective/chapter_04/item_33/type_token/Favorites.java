package practice.effective.chapter_04.item_33.type_token;

import java.util.List;

public class Favorites<T> {

  List<T> values;

  public static void main(String[] args) {
    Favorites<String> names = new Favorites<>();
    names.values.add("jinuliz");
    names.values.add(1);    // 타입이 다르기 때문에 넣지 못한다.

    Favorites<Integer> numbers = new Favorites<>();
  }

}
