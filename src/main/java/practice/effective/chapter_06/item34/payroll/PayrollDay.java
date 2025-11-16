package practice.effective.chapter_06.item34.payroll;

import static practice.effective.chapter_06.item34.payroll.PayrollDay.PayType.*;
import static practice.effective.chapter_06.item34.payroll.PayrollDay.PayType.WEEKDAY;

// 전략 열거 타입 패턴
public enum PayrollDay {
  MONDAY(WEEKDAY),
  TUESDAY(WEEKDAY),
  WEDNESDAY(WEEKDAY),
  THURSDAY(WEEKDAY),
  FRIDAY(WEEKDAY),
  SATURDAY(WEEKEND),
  SUNDAY(WEEKEND);

  /**
   * 원서 1~3쇄와 한국어판 1쇄에는 토/일요일에만 WEEKEND로 설정 가능하게 하고, 기본적으로 WEEKDAY로 만들어지도록 생성자에서 결정.
   * EX) MONDAY, SATURDAY(PayType.WEEKEND)
   *
   * 이는 저자가 코드를 간결하게 하기 위함이었는데, 열거 타입에 새로운 값을 추가할 때마다 적절한 전략 열거 타입을 선택하도록 프로그래머에게 강제하겠다는
   * 패턴의 의도를 잘못 전달할 수 있기 때문에 4쇄부터는 코드를 이와 같이 수정할 계획.
   */

  private final PayType payType;

  PayrollDay(PayType payType) {
    this.payType = payType;
  }

  int pay(int minutesWorked, int payRate) {
    return this.payType.pay(minutesWorked, payRate);
  }

  // 전략 열거 타입
  enum PayType {
    WEEKDAY {
      int overtimePay(int minsWorked, int payRate) {
        return minsWorked <= MINS_PER_SHIFT ? 0 : (minsWorked - 40) * payRate / 2;
      }
    },

    WEEKEND {
      int overtimePay(int minsWorked, int payRate) {
        return minsWorked * payRate / 2;
      }
    };

    abstract int overtimePay(int minsWorked, int payRate);

    private static final int MINS_PER_SHIFT = 8 * 60;

    int pay(int minutesWorked, int payRate) {
      int basePay = minutesWorked * payRate;
      return basePay + overtimePay(minutesWorked, payRate);
    }

  }
}
