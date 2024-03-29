package practice.effective.chapter_04.item_26.genericdao;

import org.junit.jupiter.api.Test;
import practice.effective.chapter_04.item_26.genericdao.before.AccountRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class AccountRepositoryTest {

  @Test
  void findById() {
    AccountRepository accountRepository = new AccountRepository();
    Account account = new Account(1L, "jinuliz");
    accountRepository.add(account);

    Optional<Account> byId = accountRepository.findById(1L);
    assertTrue(byId.isPresent());
  }
}