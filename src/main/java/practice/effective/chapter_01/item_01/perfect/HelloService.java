package practice.effective.chapter_01.item_01.perfect;

public interface HelloService {

  String hello();

  /**
   * 기존에는 public static만 가능하다가, java9에서 private 추가됨.
   * 인터페이스 내부에서 중복되는 코드를 재사용하고 싶은데, public으로만 선언되어
   * 밖으로 노출이 되었기 때문.
   */
  private static void prepareMessage() {
  }

  static String hi() {
    prepareMessage();
    return "hi";
  }

  static String hi1() {
    prepareMessage();
    return "hi";
  }

  static String hi2() {
    prepareMessage();
    return "hi";
  }

  default String bye() {
    return "bye";
  }

}
