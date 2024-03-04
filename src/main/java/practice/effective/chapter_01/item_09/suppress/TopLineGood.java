package practice.effective.chapter_01.item_09.suppress;

import java.io.FileReader;
import java.io.IOException;

public class TopLineGood {

  /**
   * 첫 번째 예외도 보이고, 후속 예외들도 보인다.
   * (Suppressed: java.io.StreamCorruptedException)
   */
  static String firstLineOfFile(String path) throws IOException {
    try (BadBufferedReader br = new BadBufferedReader(new FileReader(path))) {
      return br.readLine();
    }
  }

  public static void main(String[] args) throws IOException {
    System.out.println(firstLineOfFile("book.obj"));
  }
}
