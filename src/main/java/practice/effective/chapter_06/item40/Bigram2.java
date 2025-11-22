package practice.effective.chapter_06.item40;

import java.util.HashSet;
import java.util.Set;

public class Bigram2 {

  private final char first;

  private final char second;

  public Bigram2(char first, char second) {
    this.first = first;
    this.second = second;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Bigram2 bigram2 = (Bigram2) o;
    return first == bigram2.first && second == bigram2.second;
  }

  @Override
  public int hashCode() {
    return 31 * this.first + this.second;
  }

  @Override
  public String toString() {
    return "Bigram{" +
      "first=" + first +
      ", second=" + second +
      '}';
  }

  public static void main(String[] args) {
    Set<Bigram2> bigrams = new HashSet<>();
    for (int i = 0; i < 10; i++) {
      for (char ch = 'a'; ch <= 'z'; ch++) {
        bigrams.add(new Bigram2(ch, ch));
      }
    }

    System.out.println(bigrams.size());
    System.out.println(bigrams);
  }

}
