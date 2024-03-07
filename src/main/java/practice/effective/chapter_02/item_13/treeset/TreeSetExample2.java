package practice.effective.chapter_02.item_13.treeset;

import practice.effective.chapter_02.item_13.PhoneNumber;

import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample2 {

  public static void main(String[] args) {
//    TreeSet<PhoneNumber> numbers = new TreeSet<>();   // 정렬 방법을 모르니 에러 발생
    /**
     * comparator를 통해 비교 방법을 알려주어 정렬할 수 있다.
     */
    TreeSet<PhoneNumber> numbers = new TreeSet<>(Comparator.comparingInt(PhoneNumber::hashCode));
    /**
     * Set의 모든 오퍼레이션들에 synchronized가 걸린다.
     * Thread safety해짐.
     */
    Set<PhoneNumber> phoneNumbers = Collections.synchronizedSet(numbers);
    phoneNumbers.add(new PhoneNumber(123, 456, 780));
    phoneNumbers.add(new PhoneNumber(123, 456, 7890));
    phoneNumbers.add(new PhoneNumber(123, 456, 789));

    for (PhoneNumber number : numbers) {
      System.out.println(number);
    }
  }
}
