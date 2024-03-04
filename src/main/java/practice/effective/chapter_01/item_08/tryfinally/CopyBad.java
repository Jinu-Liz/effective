package practice.effective.chapter_01.item_08.tryfinally;

import java.io.*;

public class CopyBad {

  public static final int BUFFER_SIZE = 8 * 1024;

  /**
   * 해당 코드는 깔끔해보이지만, 상단에서 에러가 생기면 하단은 실행되지 않는다.
   * 또한, leak이 생길 수 있으므로 좋지 않은 코드이다.
   */
  static void copy(String src, String dst) throws IOException {
    InputStream in = new FileInputStream(src);
    OutputStream out = new FileOutputStream(dst);
    try {
      byte[] buf = new byte[BUFFER_SIZE];
      int n;
      while ((n = in.read(buf)) >= 0) {
        out.write(buf, 0, n);
      }
    } finally {
      in.close();
      out.close();
    }
  }

  public static void main(String[] args) throws IOException {
    String src = args[0];
    String dst = args[1];
    copy(src, dst);
  }
}
