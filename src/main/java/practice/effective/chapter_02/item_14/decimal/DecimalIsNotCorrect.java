package practice.effective.chapter_02.item_14.decimal;

import java.math.BigDecimal;

public class DecimalIsNotCorrect {

  public static void main(String[] args) {
    int i = 1;
    double d = 0.1;
    System.out.println(i - d * 9);    // 0.09999999999999998 가 나온다. 뒷부분 메모리 공간이 모잘라 잘림

    /**
     * BigDecimal을 사용하면 잘 계산된다.
     */
    BigDecimal bd = BigDecimal.valueOf(0.1);
    System.out.println(BigDecimal.valueOf(1).min(bd.multiply(BigDecimal.valueOf(9))));
  }
}
