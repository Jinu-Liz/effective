package practice.effective.chapter_04.item_24.adapter;

import java.io.*;

public class AdapterInJava {

  /**
   * Inputstream과 BufferedReader를 연결해주는
   * InputStreamReader가 어댑터 역할을 한다.
   */
  public static void main(String[] args) {
    try(InputStream is = new FileInputStream("number.txt");
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader reader = new BufferedReader(isr)) {
      while (reader.ready()) {
        System.out.println(reader.readLine());
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
