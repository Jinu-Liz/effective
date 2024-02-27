package practice.effective.chapter_01.item_06.perfect;

import java.util.regex.Pattern;

public class RegularExpression {

  public static final Pattern SPLIT_PATTERN = Pattern.compile(";;;");

  /**
   * 비교 대상의 길이가 1인 경우(ex: ; )에는 별 차이가 없으나,
   * 비교할 내용이 길어지면 재사용하는 것이 더 빠르다.
   *
   * 정규식을 사용하는 대표적인 메서드
   * split / replaceAll, replaceFirst / matches
   */
  public static void main(String[] args) {
    long start = System.nanoTime();
    for (int i = 0; i < 10000; i++) {
      String name = "keesun;;;whiteship";
//      name.split(";;;");
      SPLIT_PATTERN.split(name);
    }

    System.out.println(System.nanoTime() - start);
  }
}
