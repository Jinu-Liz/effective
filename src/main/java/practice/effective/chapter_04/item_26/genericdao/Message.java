package practice.effective.chapter_04.item_26.genericdao;

import lombok.Getter;

public class Message implements Entity {

  private Long id;

  @Getter
  private String body;


  @Override
  public Long getId() {
    return this.id;
  }

}
