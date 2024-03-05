package practice.effective.chapter_02.item_10;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.sql.Timestamp;

public class EqualsInJava extends Object {
  public static void main(String[] args) throws MalformedURLException {
    long time = System.currentTimeMillis();
    Timestamp timestamp = new Timestamp(time);
    Date date = new Date(time);

    // 대칭성 위배
    System.out.println(date.equals(timestamp));
    System.out.println(timestamp.equals(date));

    /**
     * 일관성 위배 가능성 있음.
     * 도메인의 IP 주소를 비교하기 때문.
     *
     * 따라서 이런 식으로 너무 깊게 비교하면 복잡해지니,
     * 단순하게 도메인 네임만 비교해라.
      */
    URL google1 = new URL("https", "about.google", "/products/");
    URL google2 = new URL("https", "about.google", "/products/");
    System.out.println(google1.equals(google2));

    // 당연히 false가 나와야함.
    System.out.println(google1.equals(null));
  }
}
