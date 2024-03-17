package practice.effective.chapter_04.item_17.part1;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * final로 만들어 상속을 막는다.
 * final 키워드는 쓸 수 있는 한 많이 쓰는 게 좋다.
 */
@Getter
@AllArgsConstructor
public final class ImmutablePhoneNumber {

  private final short areaCode, prefix, lineNum;

  /**
   * 필드를 final로 선언하면 예상치 못한 변경을 막을 수 있다.
   */
//  public void doSomething() {
//    this.areaCode = 10;
//  }
}
