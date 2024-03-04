package practice.effective.chapter_01.item_09.suppress;

import java.io.FileReader;
import java.io.IOException;

public class TopLine {

  /**
   * 가장 마지막에 발생한 예외가 보인다.
   * readLine에서 발생한 CharConversionException은 먹혀버려 보이지 않는다.
   * 디버깅 할 때는 첫 예외가 중요한데, 이를 놓쳐버린다.
   */
  static String firstLineOfFile(String path) throws IOException {
    BadBufferedReader br = new BadBufferedReader(new FileReader(path));
    try {
      return br.readLine();
    } finally {
      br.close();
    }
  }

  public static void main(String[] args) throws IOException {
    System.out.println(firstLineOfFile("book.obj"));
  }
}
