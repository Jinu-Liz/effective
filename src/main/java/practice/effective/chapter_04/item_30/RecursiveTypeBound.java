package practice.effective.chapter_04.item_30;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class RecursiveTypeBound {

  // 컬렉션에서 최댓값을 반환. - 재귀적 타입 한정 사용 ( <E extends Comparable<E>> <- E를 한 번 더 사용)
  public static <E extends Comparable<E>> E max(Collection<E> c) {
    if (c.isEmpty()) throw new IllegalArgumentException("컬렉션이 비어 있습니다.");

    E result = null;
    for (E e : c) {
      if (result == null || e.compareTo(result) > 0)
        result = Objects.requireNonNull(e);
    }

    return result;
  }

  public static void main(String[] args) {
//    List<String> argList = Arrays.asList(args);
    List<String> argList = List.of("jinuliz", "lizjinu");
    System.out.println(max(argList));
  }

}
