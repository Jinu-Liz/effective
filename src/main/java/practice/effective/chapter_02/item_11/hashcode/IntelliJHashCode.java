package practice.effective.chapter_02.item_11.hashcode;

import java.util.Objects;

public class IntelliJHashCode {

  private final String str;

  public IntelliJHashCode(String str) {
    this.str = str;
  }

  // IntelliJ 기능으로 만들 수 있음
  @Override
  public int hashCode() {
    return Objects.hash(str);
  }
}
