package practice.effective.chapter_04.item_15.item;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import practice.effective.chapter_04.item_15.member.MemberService;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class ItemServiceTest {

  /**
   * Mock 객체를 사용하지 않으면 null이 들어가 에러가 발생한다.
   * MemberService의 구현체가 package-private이라 직접 선언하여 사용하지 못할 경우,
   * Mock 객체를 사용하여 테스트를 할 수 있다.
   */
  @Mock
  MemberService memberService;

  @Test
  void itemService() {
    ItemService service = new ItemService(memberService);
    assertNotNull(service);
    assertNotNull(service.getMemberService());

  }

}