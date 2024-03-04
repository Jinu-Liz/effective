package practice.effective.chapter_01.item_08.autoclosable;

import java.io.BufferedInputStream;
import java.io.IOException;

public class AutoClosableIsGood implements AutoCloseable {

  private BufferedInputStream inputStream;

  @Override
  public void close() throws Exception {
    try {
      inputStream.close();
    } catch (IOException e) {
      throw new RuntimeException("failed to clos " + inputStream);
    }
  }
}
