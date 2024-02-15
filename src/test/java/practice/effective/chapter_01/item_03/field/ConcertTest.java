package practice.effective.chapter_01.item_03.field;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ConcertTest {

  @Test
  void perform() {
    /**
     * 인터페이스가 없으면 테스트하기가 어렵다.
     * 콘서트 테스트를 하는데, Elvis가 매번 와서 공연을 할 수는 없다.
     * 따라서 대역을 써야하는데, 인터페이스가 없으니 그럴 수 없다.
     * 그래서 이 경우에는 진짜 Elvis를 써야하기 때문에 테스트가 어렵다는 것.
     *
     * 연산이 오래 걸리는(비싼) 객체라면 진짜를 쓴다는 것은테스트가 굉장히 힘들 것.
     */
    Concert concert = new Concert(Elvis.INSTANCE);
    concert.perform();

    Assertions.assertTrue(concert.isLightsOn());
    Assertions.assertTrue(concert.isMainStateOpen());
  }
}