package practice.effective.chapter_02.item_10.make_equals.intellij;

import java.util.Objects;

/**
 * IntelliJ의 기능에 equals를 만들어주는 기능이 있음.
 * 다만, 필드가 늘어날 때마다 다시 만들어주어야한다는 단점이 있다.
 */
public class IntelliJ {

  private final String str;

  public IntelliJ(String str) {
    this.str = str;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    IntelliJ intelliJ = (IntelliJ) o;
    return Objects.equals(str, intelliJ.str);
  }

  @Override
  public int hashCode() {
    return Objects.hash(str);
  }
}
