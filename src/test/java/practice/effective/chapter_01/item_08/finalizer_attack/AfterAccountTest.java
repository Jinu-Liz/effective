package practice.effective.chapter_01.item_08.finalizer_attack;

import org.junit.jupiter.api.Test;
import practice.effective.chapter_01.item_08.finalizer_attack.after.AfterAccount;
import practice.effective.chapter_01.item_08.finalizer_attack.after.BrokenAfterAccount;
import practice.effective.chapter_01.item_08.finalizer_attack.before.Account;
import practice.effective.chapter_01.item_08.finalizer_attack.before.BrokenAccount;

import java.math.BigDecimal;

class AfterAccountTest {

  @Test
  void normalAccount() {
    Account account = new Account("jinuliz");
    account.transfer(BigDecimal.valueOf(10.4), "hello");
  }

  @Test
  void putinAccount() throws InterruptedException {
    Account account = null;
    try {
      account = new BrokenAccount("푸틴");
    } catch (Exception e) {
      System.out.println("이러면???");
    }

    System.gc();
    Thread.sleep(3000L);
  }

  @Test
  void preventPutinAccount() throws InterruptedException {
    AfterAccount account = null;
    try {
      account = new BrokenAfterAccount("푸틴");
    } catch (Exception e) {
      System.out.println("이러면???");
    }

    System.gc();
    Thread.sleep(3000L);
  }
}