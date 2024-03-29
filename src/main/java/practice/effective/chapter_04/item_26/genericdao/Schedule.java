package practice.effective.chapter_04.item_26.genericdao;

import lombok.Getter;

import java.time.LocalDateTime;

public class Schedule implements Entity {

  private Long id;

  @Getter
  private LocalDateTime when;

  @Override
  public Long getId() {
    return null;
  }

}
