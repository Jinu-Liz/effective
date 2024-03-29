package practice.effective.chapter_04.item_26.genericdao.before;

import practice.effective.chapter_04.item_26.genericdao.Account;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class AccountRepository {

  private Set<Account> accounts;

  public AccountRepository() {
    this.accounts = new HashSet<>();
  }

  public Optional<Account> findById(Long id) {
    return this.accounts.stream()
      .filter(a -> a.getId().equals(id))
      .findAny();
  }

  public void add(Account account) {
    this.accounts.add(account);
  }
}
