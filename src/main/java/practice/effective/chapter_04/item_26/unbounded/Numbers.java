package practice.effective.chapter_04.item_26.unbounded;

import java.util.HashSet;
import java.util.Set;

/**
 * <?>과 raw타입은 아무거나 넣을 수 있다는 것은 같지만,
 * raw 타입은 아무거나 추가할 수 있어, 안전하지가 않다.
 * 따라서 와일드 타입을 선언해서 사용하는 것이 좋다.
 */
public class Numbers {
  static int numElementsInCommon(Set<?> s1, Set<?> s2) {

    // 비한정적 와일드카드 타입은 null만 넣을 수 있다.
//    s1.add(10); // 에러
    s1.add(null);
    int result = 0;
    for (Object o1 : s1) {
      if (s2.contains(o1)) result++;
    }

    return result;
  }

  static int numElementsInCommon2(Set s1, Set s2) {
    // raw타입은 아무거나 넣을 수 있다.
    s1.add(10);
    int result = 0;
    for (Object o1 : s1) {
      if (s2.contains(o1)) result++;
    }

    return result;
  }

  public static void main(String[] args) {
    Set<Integer> set = new HashSet<>();
    Set<?> mySet = set;
    System.out.println(Numbers.numElementsInCommon(Set.of(1, 2, 3), Set.of(1, 2)));
  }
}
