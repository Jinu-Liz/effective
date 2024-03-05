package practice.effective.chapter_02.item_10.inheritance;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GoodCaseInsensitiveString {

  private final String s;

  public GoodCaseInsensitiveString(String s) {
    this.s = Objects.requireNonNull(s);
  }

  /**
   * 수정한 equals.
   * 자기 자신의 타입만 지원해야한다.
   * 다른 타입을 지원하기 시작하면 대칭성이 깨질 수 있다.
   */
  @Override
  public boolean equals(Object o) {
    return o instanceof GoodCaseInsensitiveString && ((GoodCaseInsensitiveString) o).s.equalsIgnoreCase(s);
  }

  public static void main(String[] args) {
    GoodCaseInsensitiveString cis = new GoodCaseInsensitiveString("Polish");
    GoodCaseInsensitiveString cis2 = new GoodCaseInsensitiveString("polish");
    String polish = "polish";

    System.out.println(cis.equals(polish));
    System.out.println(polish.equals(cis));
    System.out.println(cis.equals(cis2));
    System.out.println(cis2.equals(cis));

    List<GoodCaseInsensitiveString> list = new ArrayList<>();
    list.add(cis);

    System.out.println(list.contains(polish));
  }
}
