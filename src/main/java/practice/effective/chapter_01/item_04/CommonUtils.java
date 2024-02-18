package practice.effective.chapter_01.item_04;

import lombok.experimental.UtilityClass;

//@UtilityClass
public class CommonUtils {

  /**
   * 기본 생성자를 private으로 막아, 사용하지 못하게 만든다.
   * lombok의 @UtilityClass 어노테이션을 사용해도 됨.
   */
  private CommonUtils() {
    throw new AssertionError();
  }

  public static String hello() {
    return "hello";
  }

}
