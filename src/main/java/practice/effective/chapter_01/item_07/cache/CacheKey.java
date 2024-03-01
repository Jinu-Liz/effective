package practice.effective.chapter_01.item_07.cache;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@EqualsAndHashCode
@ToString
@Data
public class CacheKey {

  private Integer id;

  private LocalDateTime created;

  public CacheKey(Integer id) {
    this.id = id;
    this.created = LocalDateTime.now();
  }

}
