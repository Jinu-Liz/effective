package practice.effective.chapter_04.item_26.genericdao;

import lombok.Getter;

public class Account implements Entity {

  private Long id;

  @Getter
  private String username;

  public Account(Long id, String username) {
    this.id = id;
    this.username = username;
  }

  @Override
  public Long getId() {
    return this.id;
  }
}
