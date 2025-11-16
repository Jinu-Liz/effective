package practice.effective.chapter_06.item34.payroll;

/**
 * enum별로 처리하기 때문에 코드 관리가 어렵고
 * 상수들끼리 메서드 재사용이 어렵다.
 */
public enum PayrollDayOrigin {

  MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

  private static final int MINS_PER_SHIFT = 8 * 60;

  int pay(int minutesWorked, int payRate) {
    int basePay = minutesWorked * payRate;

    int overTimePay;

    switch (this) {
      case SATURDAY: case SUNDAY:
        overTimePay = basePay / 2;
        break;

      default:    // 주중
        overTimePay = minutesWorked <= MINS_PER_SHIFT ? 0 : (minutesWorked - MINS_PER_SHIFT) * payRate / 2;
    }

    return basePay + overTimePay;
  }

}
