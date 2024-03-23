package practice.effective.chapter_04.item_20.templatemethod;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public abstract class FileProcessor {

  private String path;

  public FileProcessor(String path) {
    this.path = path;
  }

  /**
   * 템플릿이 정해져 있고, 그 중 일부분을 상속하여
   * 재정의 후 사용 가능하도록 만들어 유연성을 가져감.
   */
  public final int process() {
    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
      int result = 0;
      String line = null;
      while ((line = br.readLine()) != null) {
        result = getResult(result, Integer.parseInt(line));
      }

      return result;
    } catch (IOException e) {
      throw new IllegalArgumentException(path + "에 해당하는 파일이 없습니다.", e);
    }
  }

  protected abstract int getResult(int result, int number);

}
