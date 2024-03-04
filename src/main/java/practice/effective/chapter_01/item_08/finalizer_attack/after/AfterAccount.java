package practice.effective.chapter_01.item_08.finalizer_attack.after;

import java.math.BigDecimal;

public class AfterAccount {

  private String accountId;

  public AfterAccount(String accountId) {
    this.accountId = accountId;

    if (accountId.equals("푸틴")) {
      throw new IllegalArgumentException("푸틴은 계정을 막습니다.");
    }
  }

  public void transfer(BigDecimal amount, String to) {
    System.out.printf("transfer %f from %s to %s\n", amount, accountId, to);
  }

  /**
   * final로 만들어 오버라이딩을 할 수 없도록 만든다.
   */
  @Override
  protected final void finalize() throws Throwable {
  }
}
