package practice.effective.chapter_08.item50;

import java.util.Date;

// 기간을 표현하는 클래스. 불변식을 지키지 못했다.
public final class Period {

  private final Date start;

  private final Date end;

  public Period(Date start, Date end) {
    if (start.compareTo(end) > 0) throw new IllegalArgumentException(start + "가 " + end + "보다 늦다.");

    this.start = start;
    this.end = end;
  }

  @Override
  public String toString() {
    return this.start + " ~ " + this.end;
  }

  public Date start() { return this.start; }

  public Date end() { return this.end; }

}
