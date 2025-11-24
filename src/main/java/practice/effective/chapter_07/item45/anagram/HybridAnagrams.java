package practice.effective.chapter_07.item45.anagram;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// 스트림을 적절히 활용하면 깔끔하고 명료해진다.
public class HybridAnagrams {

  public static void main(String[] args) throws IOException {
    Path dictionary = Paths.get(args[0]);
    int minGroupSize = Integer.parseInt(args[1]);

    try (Stream<String> words = Files.lines(dictionary)) {
      words.collect(Collectors.groupingBy(word -> alphabetizedForm(word)))
        .values().stream()
        .filter(group -> group.size() >= minGroupSize)
        .forEach(g -> System.out.println(g.size() + ": " + g));
    }
  }

  private static String alphabetizedForm(String word) {
    char[] a = word.toCharArray();
    Arrays.sort(a);
    return new String(a);
  }
}
