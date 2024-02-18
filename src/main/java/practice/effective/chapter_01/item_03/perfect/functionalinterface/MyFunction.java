package practice.effective.chapter_01.item_03.perfect.functionalinterface;

/**
 * 타입을 정의할 수 없는 경우에는, 직접 정의할 수 있다.
 *
 * 인터페이스 안에 메서드가 하나만 선언되어 있어야 한다.
 * default 또는 static으로 기능이 정의된 메서드는 더 선언 가능하지만,
 * implementation이 비어있는 메서드는 하나만 선언되어있어야한다.
 */
@FunctionalInterface
public interface MyFunction {

  String valueOf(Integer integer);

  static String hello() {
    return "hello";
  }
}
