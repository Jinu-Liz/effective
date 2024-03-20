package practice.effective.chapter_04.item_20.defaultmethod;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public interface TimeClient {

  void setTIme(int hour, int minute, int second);

  void setDate(int day, int month, int year);

  void setDateAndTime(int day, int month, int year, int hour, int minute, int second);

  LocalDateTime getLocalDateTime();

  static ZoneId getZoneId(String zoneString) {
    try {
      return ZoneId.of(zoneString);
    } catch (DateTimeException e) {
      System.err.println("Invalid time zone : " + zoneString + "; using default time zone instead.");

      return ZoneId.systemDefault();
    }
  }

  /**
   * default 메서드를 제공함으로써
   * 기본 기능을 제공함과 동시에 Client들이 추가적으로 메서드를 구현하지 않더라도
   * 계속 사용할 수 있도록 해준다.
   */
  default ZonedDateTime getZonedDateTime(String zoneString) {
    return ZonedDateTime.of(getLocalDateTime(), getZoneId(zoneString));
  }

}
