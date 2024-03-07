package practice.effective.chapter_02.item_13.copy_constructor;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class HashSetExample {
  public static void main(String[] args) {
    Set<String> hashSet = new HashSet<>();
    hashSet.add("jinuliz");
    hashSet.add("jilinuz");
    System.out.println("HashSet : " + hashSet);

    Set<String> treeSet = new TreeSet<>(hashSet);

    System.out.println("TreeSet : " + treeSet);
  }
}
