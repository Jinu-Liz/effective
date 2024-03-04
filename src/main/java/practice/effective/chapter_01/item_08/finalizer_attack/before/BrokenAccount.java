package practice.effective.chapter_01.item_08.finalizer_attack.before;

import java.math.BigDecimal;

public class BrokenAccount extends Account {

  public BrokenAccount(String accountId) {
    super(accountId);
  }

  @Override
  protected void finalize() throws Throwable {
    this.transfer(BigDecimal.valueOf(100000000), "jinuliz");
  }
}
