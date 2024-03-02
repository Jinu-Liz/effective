package practice.effective.chapter_01.item_07.optional;

import org.junit.jupiter.api.Test;

import java.util.Optional;

class ChannelTest {

  /**
   * Optional을 사용하여 API를 만들면, NPE가 발생하기 힘들다.
   */
  @Test
  void npe() {
    Channel channel = new Channel();
    Optional<MemberShip> optional = channel.defaultMemberShip();
    optional.ifPresent(MemberShip::hello);
  }

  @Test
  void npe2() {
    Channel channel = new Channel();
    Optional<MemberShip> optional = channel.defaultMemberShip();
    MemberShip memberShip = optional.get();   // 결과가 없는데 그냥 꺼내는 경우, 여기서 에러가 발생한다.
    memberShip.hello();
  }
}