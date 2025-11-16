package practice.effective.chapter_06.item36.anti_pattern;

/**
 * 비트 필드의 경우, 정수 열거 상수의 단점을 모두 가지고 있다.
 * 필드값을 그대로 출력할 경우, 해석하기가 어렵다.
 */
public class Text {

  public static final int STYLE_BOLD = 1 << 0;  // 굵게

  public static final int STYLE_ITALIC = 1 << 1;  // 기울이기

  public static final int STYLE_UNDERLINE = 1 << 2;   // 밑줄

  public static final int STYLE_STRIKETHROUGH = 1 << 3;   // 취소선

  private int currentStyle;

  public void applyStyles(int style) {
    System.out.printf("Applying styles %s to test%n", style);
    this.currentStyle = style;
  }

  public boolean isBold() {
    return (currentStyle & STYLE_BOLD) == STYLE_BOLD;
  }

  public boolean isItalic() {
    return (currentStyle & STYLE_ITALIC) == STYLE_ITALIC;
  }

  public static void main(String[] args) {
    Text text = new Text();
    text.applyStyles(STYLE_BOLD | STYLE_ITALIC);
    System.out.println(text.isBold() + " " + text.isItalic());
  }
}
