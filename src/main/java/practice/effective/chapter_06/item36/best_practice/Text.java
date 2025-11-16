package practice.effective.chapter_06.item36.best_practice;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public class Text {

  public enum Style { BOLD, ITALIC, UNDERLINE, STRIKETHROUGH }

  public Set<Style> styles;

  public void applyStyles(Set<Style> styles) {
    System.out.printf("Applying styles %s to test%n", Objects.requireNonNull(styles));
    this.styles = styles;
  }

  public boolean isBold() {
    return styles.contains(Style.BOLD);
  }

  public boolean isItalic() {
    return styles.contains(Style.ITALIC);
  }

  /**
   * EnumSet 내부에서는 비트 연산을 사용하여 직접 비트를 다루지 않아도 효율적으로 연산 작업을 진행한다.
   * 따라서, EnumSet을 사용하면 효율적이고 가독성 좋은 코드를 작성할 수 있다.
   */
  public static void main(String[] args) {
    Text text = new Text();
    text.applyStyles(EnumSet.of(Style.BOLD, Style.ITALIC));
    System.out.println(text.isBold() + " " + text.isItalic());
  }

}
