package practice.effective.chapter_06.item40;

import java.util.HashSet;
import java.util.Set;

public class Bigram {

  private final char first;

  private final char second;

  public Bigram(char first, char second) {
    this.first = first;
    this.second = second;
  }

  public boolean equals(Bigram bigram) {  // 매개변수 타입이 아니기 때문에 over loading
    return bigram.first == this.first && bigram.second == this.second;
  }

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

  // Set에 같은 객체가 들어가지 않는 것으로 기대하지만, 중복해서 들어간다. equals가 다르게 작동하기 때문.
  public static void main(String[] args) {
    Set<Bigram> bigrams = new HashSet<>();
    for (int i = 0; i < 10; i++) {
      for (char ch = 'a'; ch <= 'z'; ch++) {
        bigrams.add(new Bigram(ch, ch));
      }
    }

    System.out.println(bigrams.size());
    System.out.println(bigrams);
  }

}
