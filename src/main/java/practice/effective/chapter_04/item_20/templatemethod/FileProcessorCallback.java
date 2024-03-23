package practice.effective.chapter_04.item_20.templatemethod;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.BiFunction;

public class FileProcessorCallback {

  private String path;

  public FileProcessorCallback(String path) {
    this.path = path;
  }

  /**
   * 템플릿 콜백 패턴.
   * 상속을 사용하지 않고도 확장 가능한 메서드를 만들 수 있다.
   */
  public final int process(BiFunction<Integer, Integer, Integer> operator) {
    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
      int result = 0;
      String line = null;
      while ((line = br.readLine()) != null) {
        result = operator.apply(result, Integer.parseInt(line));
      }

      return result;
    } catch (IOException e) {
      throw new IllegalArgumentException(path + "에 해당하는 파일이 없습니다.", e);
    }
  }

}
