package practice.effective.chapter_04.item_28.erasure;

import java.util.ArrayList;
import java.util.List;

public class MyGeneric {
  public static void main(String[] args) {
    List<String> names = new ArrayList<>();
    names.add("jinuliz");
    String name = names.get(0);
    System.out.println(name);
  }
}
