package practice.effective.chapter_08.item52;

import java.util.*;

/**
 * 오버로딩은 오버라이딩과 다르게 동작하기 때문에, 이를 주의해야 한다.
 * 매개변수 수가 같은 경우에는 다중정의를 하지 않는게 가장 좋다.
 * 메서드명을 다르게 지어 구분하도록 하자.
 */
public class CollectionClassifier {

  public static String classify(Set<?> set) { return "집합"; }

  public static String classify(List<?> list) { return "리스트"; }

  public static String classify(Collection<?> collection) { return "그 외"; }

  /**
   * 각각 찍힐 것 같지만, '그 외'만 3회 찍힌다.
   */
  public static void main(String[] args) {
    Collection<?>[] collections = {
      new HashSet<String>(),
      new ArrayList<String>(),
      new HashMap<String, String>().values()
    };

    for (Collection<?> collection : collections) {
      System.out.println(classify(collection));
    }
  }

}
