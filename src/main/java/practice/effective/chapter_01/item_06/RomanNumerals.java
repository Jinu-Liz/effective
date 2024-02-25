package practice.effective.chapter_01.item_06;

import java.util.regex.Pattern;

// 값비싼 객체를 재사용해 성능을 끌어올릴 수 있다.
public class RomanNumerals {
  static boolean isRomanNumeralSlow(String str) {
    return str.matches("^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
  }

  // 값비싼 객체를 재사용해 성능을 개선한다.
  private static final Pattern ROMAN = Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

  static boolean isRomanNumeralFast(String str) {
    return ROMAN.matcher(str).matches();
  }

  public static void main(String[] args) {
    boolean result = false;
    long start = System.nanoTime();
    for (int i = 0; i < 100; i++) {
      result = isRomanNumeralSlow("MCMLXXVI");
//      result = isRomanNumeralFast("MCMLXXVI");
    }
    long end = System.nanoTime();

    System.out.println(end - start);
    System.out.println(result);
  }
}
