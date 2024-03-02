package practice.effective.chapter_01.item_07.optional;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.OptionalLong;

public class Channel {

  private int numOfSubscribers;

  /**
   * Java 8에서 Optional이 추가됨.
   * null 대신 Optional을 사용하여 비어있을 경우를 처리할 수 있다.
   *
   * 단, Optional로 Collection을 감싸면 안된다.
   * Collection의 경우, 자체적으로 비어있는지 확인할 수 있는 메서드가 존재한다.
   * 따라서 다시 감쌀 필요가 없다.
   */
  public Optional<MemberShip> defaultMemberShip() {
    // Optional.empty()가 아니라 null을 바로 넘기는 것은 Optional을 쓰는 의미를 퇴색시킨다. 절대 금지.
    return (this.numOfSubscribers < 2000) ? Optional.empty() : Optional.of(new MemberShip());
  }

  /**
   * Optional은 리턴 타입에 사용하기 위하여 만들어졌으므로,
   * 매개 변수로 사용하는 것은 적절하지 않다.
   * 매개 변수로 사용할 경우, null이 존재할 수 있어 다시 검사해야한다.
   */
  public Optional<MemberShip> defaultMemberShipBadCase(Optional<MemberShip> optional) {
    if (optional != null) {
      optional.ifPresent(System.out::println);
    }

    return (this.numOfSubscribers < 2000) ? Optional.empty() : Optional.of(new MemberShip());
  }

  /**
   * primitive type의 경우, 감쌀 수 없기 때문에 별도의 Optional을 사용해주면 된다.
   */
  public void optionalType() {
    OptionalLong.empty();
    OptionalInt.of(2);
  }
}
