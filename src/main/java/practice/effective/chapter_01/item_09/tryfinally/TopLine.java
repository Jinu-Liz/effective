package practice.effective.chapter_01.item_09.tryfinally;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TopLine {

  // try-finally는 더 이상 자원을 회수하는 최선의 방책이 아니다.
  static String firstLineOfFile(String path) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader(path));
    try {
      return br.readLine();
    } finally {
      br.close();
    }
  }

  public static void main(String[] args) throws IOException {
    String path = args[0];
    System.out.println(firstLineOfFile(path));
  }
}
