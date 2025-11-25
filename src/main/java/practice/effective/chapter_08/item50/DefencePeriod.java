package practice.effective.chapter_08.item50;

import java.util.Date;

public final class DefencePeriod {

  private final Date start;

  private final Date end;

  // 수정한 생성자. 매개변수의 방어적 복사본을 만든다. clone()은 사용 x. 자식 클래스에서 재정의 될 수 있기 때문.
  public DefencePeriod(Date start, Date end) {
    this.start = new Date(start.getTime());
    this.end = new Date(end.getTime());

    if (start.compareTo(end) > 0) throw new IllegalArgumentException(start + "가 " + end + "보다 늦다.");
  }

  // 수정한 접근자 - 필드의 방어적 복사본 반환
  public Date start() { return new Date(start.getTime()); }

  public Date end() { return new Date(end.getTime()); }

  @Override
  public String toString() {
    return this.start + " ~ " + this.end;
  }
}
