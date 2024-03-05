package practice.effective.chapter_02.item_10.make_equals.lombok;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Lombok의 어노테이션을 사용하면
 * 편법으로 equals를 만들어줌
 */
@EqualsAndHashCode
@ToString
public class Point {

  private final int x;

  private final int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
}
