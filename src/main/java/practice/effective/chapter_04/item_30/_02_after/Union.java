package practice.effective.chapter_04.item_30._02_after;

import java.util.HashSet;
import java.util.Set;

public class Union {

  /**
   * 제네릭 메서드를 만들어 쓰는 것을 권장.
   */
  public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
    Set<E> result = new HashSet<>(s1);
    result.addAll(s2);

    return result;
  }

  public static void main(String[] args) {
    Set<String> guys = Set.of("Tom", "Dick", "Harry");
//    Set<Integer> stooges = Set.of(1, 2, 3);   // Integer 이기 때문에 String과 합치지 못함.
    Set<String> stooges = Set.of("Rally", "Moe", "Curly");
    Set all = union(guys, stooges);

    for (Object o : all) {
      System.out.println((String) o);
    }
  }
}
