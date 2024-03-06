package practice.effective.chapter_02.item_11.hashtable;

import practice.effective.chapter_02.item_11.hashcode.PhoneNumber;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
  public static void main(String[] args) {
    Map<PhoneNumber, String> map = new HashMap<>();
    PhoneNumber phoneNumber1 = new PhoneNumber(123, 456, 7890);
    PhoneNumber phoneNumber2 = new PhoneNumber(456, 789, 1111);

    /**
     * 다른 인스턴스인데 같은 hashCode를 쓰면 Hash Collision(해시 충돌)이 발생한다.
     * 해시 충돌이 발생하면, hash bucket에 들어있는 Object를 Object가 아니라 LinkedList로 만들어준다.
     * hashCode가 같으면 같은 bucket 안에 있는 LinkedList로 들어가게 된다.
     * 여기에서 get을 하게 되면, LinkedList를 순회하며 각 객체마다 equals로 비교하여 맞는 값을 꺼내오게 된다.
     * hashCode를 통해 바로 값을 꺼내오는 HashMap을 쓰는 장점이 사라지고, List를 사용하는 것과 똑같이 된다.
     * 시간복잡도가 O1이 아니라 On이 되어버린다.
     */
    System.out.println(phoneNumber1.equals(phoneNumber2));
    System.out.println(phoneNumber1.hashCode());
    System.out.println(phoneNumber2.hashCode());

    map.put(phoneNumber1, "jinuliz");
    map.put(phoneNumber2, "lizjinu");

    String s = map.get(new PhoneNumber(123, 456, 7890));
    System.out.println(s);
  }
}
