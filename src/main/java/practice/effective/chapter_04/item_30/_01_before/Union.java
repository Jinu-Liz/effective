package practice.effective.chapter_04.item_30._01_before;

import java.util.HashSet;
import java.util.Set;

public class Union {

  public static Set union(Set s1, Set s2) {
    Set result = new HashSet(s1);
    result.addAll(s2);

    return result;
  }

  public static void main(String[] args) {
    Set guys = Set.of("Tom", "Dick", "Harry");
    Set stooges = Set.of(1, 2, 3);   // Integer 이기 때문에 String과 합치지 못함.
//    Set stooges = Set.of("Rally", "Moe", "Curly");
    Set all = union(guys, stooges);

    for (Object o : all) {
      System.out.println((String) o);
    }
  }
}
