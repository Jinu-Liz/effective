package practice.effective.chapter_07.item43.method_reference;

import java.util.Map;
import java.util.TreeMap;

public class Freq {

  /**
   * 메서드의 이름이 직관적이다. -> 메서드 참조
   * 파라미터 이름이 하고자하는 바를 더 잘 표현한다 -> 람다
   * 메서드와 람다가 같은 클래스에 있는 경우 -> 람다
   */
  public static void main(String[] args) {
    args = new String[] {"a", "b", "b", "a", "b", "c"};
    Map<String, Integer> frequencyTable = new TreeMap<>();
    for (String s : args) {
      frequencyTable.merge(s, 1, (count, incr) -> count + incr);    // 람다
    }
    System.out.println(frequencyTable);

    frequencyTable.clear();
    for (String s : args) {
      frequencyTable.merge(s, 1, Integer::sum);   // 메서드 참조
    }
    System.out.println(frequencyTable);

    for (String s : args) {
      frequencyTable.merge(s, 1, Freq::sum);
    }
  }

  private static Integer sum(Integer count, Integer incr) {
    return count + incr;
  }

}
