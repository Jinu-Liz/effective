package practice.effective.chapter_01.item_08.autoclosable;

import java.io.*;

/**
 * IO 계열인 경우, AutoCloseable보다 Closeable을 사용하는 것이 더 좋은 선택일 수 있다.
 */
public class AutoClosableIsGoodExplain implements AutoCloseable {

  private BufferedReader reader;

  public AutoClosableIsGoodExplain(String path) {
    try {
      this.reader = new BufferedReader(new FileReader(path));
    } catch (FileNotFoundException e) {
      throw new IllegalArgumentException(path);
    }
  }

  /**
   * throws Exception
   * 클라이언트 측에 처리를 맡김. 예외는 가능한 구체적으로.
   *
   * try-catch문 사용
   * 자체적으로 처리. 클라이언트는 신경쓰지 않아도 됨.
   * 로깅만 하거나, RuntimeException을 던지거나.
   *
   * 여러 번 호출되더라도 같은 결과가 도출되어야함. (멱등성)
   */
  @Override
  public void close() throws IOException {
    this.reader.close();
  }
}
