package practice.effective.chapter_04.item_26.genericdao.after;

import practice.effective.chapter_04.item_26.genericdao.Account;

/**
 * GenericRepository를 Account 타입을 주고 상속받기만 하면 된다.
 */
public class AccountRepository extends GenericRepository<Account> {
}
