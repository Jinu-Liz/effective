package practice.effective.chapter_08.item50;

import java.util.Date;

public class Attacks {

  public static void main(String[] args) {
    // Period 인스턴스의 내부를 공격
    Date start = new Date();
    Date end = new Date();
    Period period = new Period(start, end);
    end.setYear(78);  // period의 내부를 변경
    System.out.println(period);

    // 두 번째 공격
    start = new Date();
    end = new Date();
    period = new Period(start, end);
    period.end().setTime(78);
    System.out.println(period);
  }
}
