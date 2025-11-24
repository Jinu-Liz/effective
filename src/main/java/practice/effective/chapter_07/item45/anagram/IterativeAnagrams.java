package practice.effective.chapter_07.item45.anagram;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class IterativeAnagrams {
  public static void main(String[] args) throws FileNotFoundException {
    File dictionary = new File(args[0]);
    int minGroupSize = Integer.parseInt(args[1]);

    // cat, tac 같은 문자로 만들어진 단어(아나그램)
    Map<String, Set<String>> groups = new HashMap<>();
    try (Scanner s = new Scanner(dictionary)) {
      while (s.hasNext()) {
        String word = s.next();
        groups.computeIfAbsent(alphabetizedForm(word),
          (unused) -> new TreeSet<>()).add(word);
      }
    }

    for (Set<String> group : groups.values()) {
      if (group.size() >= minGroupSize) {
        System.out.println(group.size() + ": " + group);
      }
    }
  }

  private static String alphabetizedForm(String word) {
    char[] a = word.toCharArray();
    Arrays.sort(a);
    return new String(a);
  }
}
