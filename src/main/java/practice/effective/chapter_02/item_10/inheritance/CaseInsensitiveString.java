package practice.effective.chapter_02.item_10.inheritance;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CaseInsensitiveString {

  private final String s;

  public CaseInsensitiveString(String s) {
    this.s = Objects.requireNonNull(s);
  }

  // 대칭성 위배.
  @Override
  public boolean equals(Object o) {
    if (o instanceof CaseInsensitiveString)
      return s.equalsIgnoreCase(((CaseInsensitiveString) o).s);

    if (o instanceof String)    // 한 방향으로만 작동한다.
      return s.equalsIgnoreCase((String) o);

    return false;
  }

  public static void main(String[] args) {
    CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
    String polish = "polish";

    /**
     * CaseInsensitiveString은 내부적으로 String을 지원하지만,
     * String의 경우에는 CaseInsensitiveString이라는 클래스의 존재를 모른다.
     * 따라서 타입이 다르므로 false.
     */
    System.out.println(cis.equals(polish));
    System.out.println(polish.equals(cis));

    List<CaseInsensitiveString> list = new ArrayList<>();
    list.add(cis);

    System.out.println(list.contains(polish));
  }
}
