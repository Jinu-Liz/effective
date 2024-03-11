package practice.effective.chapter_04.item_15.member;

import java.util.Arrays;

/**
 * 구현체의 경우, package-private이 더 어울린다.
 * 외부에서는 MemberService라는 인터페이스만 사용하는 것이 좋고
 * 때문에 구현체는 public으로 노출시키지 않는 것이 좋기 때문.
 *
 * item에서 MemberService를 사용할 경우, item은 구현체가 무엇인지 알 필요가 없다.
 */
class DefaultMemberService implements MemberService {

  private String name;

  /**
   * 해당 클래스를 한 군데에서만 사용할 경우, private static 클래스로
   * 내부에서 중첩시켜 사용하라.
   */
  private static class PrivateStaticClass { }


  /**
   * 그냥 private class인 경우, 해당 내부 클래스를 감싸고 있는
   * 외부 클래스를 자동으로 참조한다.
   * 따라서, private static으로 만들어 외부클래스가 참조되지 않도록 하는 것이 좋다.
   */
  private class PrivateClass {

    void doPrint() {
      System.out.println(name);   // 외부클래스의 필드를 아무렇지 않게 참조.
    }

  }

  public static void main(String[] args) {
    Arrays.stream(PrivateClass.class.getDeclaredFields()).forEach(System.out::println);
  }
}
