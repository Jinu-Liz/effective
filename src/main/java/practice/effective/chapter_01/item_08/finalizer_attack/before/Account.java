package practice.effective.chapter_01.item_08.finalizer_attack.before;

import java.math.BigDecimal;

public class Account {

  private String accountId;

  public Account(String accountId) {
    this.accountId = accountId;

    if (accountId.equals("푸틴")) {
      throw new IllegalArgumentException("푸틴은 계정을 막습니다.");
    }
  }

  public void transfer(BigDecimal amount, String to) {
    System.out.printf("transfer %f from %s to %s\n", amount, accountId, to);
  }

  @Override
  protected void finalize() throws Throwable {
  }
}
