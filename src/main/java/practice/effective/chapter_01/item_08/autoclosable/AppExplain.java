package practice.effective.chapter_01.item_08.autoclosable;

import java.io.IOException;

public class AppExplain {
  public static void main(String[] args) {
    try (AutoClosableIsGoodExplain explain = new AutoClosableIsGoodExplain("")) {
      // TODO 자원 반납 처리
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
