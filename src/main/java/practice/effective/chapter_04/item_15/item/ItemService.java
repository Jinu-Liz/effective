package practice.effective.chapter_04.item_15.item;

import practice.effective.chapter_04.item_15.member.MemberService;

public class ItemService {

  public static final String NAME = "jinuliz";

  /**
   * 배열을 public static final로 선언하면
   * 내부가 변경이 될 수 있기 때문에 권장하지 않는다.
   */
  public static final String[] NAMES = new String[10];

  private MemberService memberService;

  boolean onSale;

  protected int saleRate;

  public ItemService(MemberService memberService) {
    if (memberService == null) throw new IllegalArgumentException("MemberService should not be null");
    this.memberService = memberService;
  }

  /**
   * 기존에 public하게 제공하고 있었다면 상관 없지만,
   * Test 때문에 public한 메서드나 멤버변수를 만드는 것은
   * 권장하지 않는다.
   */
  MemberService getMemberService() {
    return this.memberService;
  }

}
