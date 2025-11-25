package practice.effective.chapter_08.item49;

import java.util.Objects;

/**
 * 메서드 본문을 타기 전에 파라미터 검증을 해야한다.
 * 1. 메서드 이전에 검증을 끝낸 후, 메서드 실행
 * 2. 메서드 실행 시, 처음에 검증을 시작한 후 본문 실행
 *
 * 2번에서 requireNonNull을 사용하면 유용함.
 * 그러나 1번이 가장 나은듯.
 */
public class RequireNonNullExample {

  public static void main(String[] args) {
    extracted("jinuliz");
  }

  public static void extracted(String name) {
    // 해당 메서드를 requireNonNull로 대체할 수 있다.
    if (name == null) {
      throw new NullPointerException("name must not be null");
    }

    String value = null;

    try {
      Objects.requireNonNull(value, "the value must not be null");
    } catch (NullPointerException e) {
      System.out.println(e.getMessage());
    }

    value = "Hello, world!";

    String result = Objects.requireNonNull(value, "the value must not be null");
  }
}
