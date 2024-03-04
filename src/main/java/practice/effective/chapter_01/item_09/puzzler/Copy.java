package practice.effective.chapter_01.item_09.puzzler;

import java.io.*;

public class Copy {

  public static final int BUFFER_SIZE = 8 * 1024;

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
      try {
        // 만약 여기서 runtimeException이 발생하면 뒤의 코드는 실행되지 않으므로 안전하지 않다.
        out.close();
      } catch (IOException e) {
        // TODO 이렇게 하면 되는거 아닌가??
      }

      try {
        in.close();
      } catch (IOException e) {
        // TODO 안전한가??
      }
    }
  }

  public static void main(String[] args) throws IOException {
    String src = args[0];
    String dst = args[1];
    copy(src, dst);
  }
}
