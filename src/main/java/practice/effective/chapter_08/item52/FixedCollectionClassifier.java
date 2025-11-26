package practice.effective.chapter_08.item52;

import java.util.*;

/**
 * 정상 동작 수정 버전
 */
public class FixedCollectionClassifier {

  public static String classify(Collection<?> collection) {

    return collection instanceof Set ? "집합" :
            collection instanceof List ? "리스트" : "그 외";
  }

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
