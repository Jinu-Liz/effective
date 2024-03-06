package practice.effective.chapter_02.item_11.hashcode;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class LombokHashCode {

  private final String str;

  public LombokHashCode(String str) {
    this.str = str;
  }
}
