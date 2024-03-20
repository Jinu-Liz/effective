package practice.effective.chapter_04.item_20.defaultmethod;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * 추상 클래스는 하나 밖에 상속받지 못하지만,
 * 인터페이스는 여러 개 사용이 가능하다.
 */
public class SimpleTimeClient implements TimeClient, Serializable {

  private LocalDateTime dateAndTime;

  public SimpleTimeClient() {
    this.dateAndTime = LocalDateTime.now();
  }

  @Override
  public void setTIme(int hour, int minute, int second) {
    LocalDate currentDate = LocalDate.from(dateAndTime);
    LocalTime timeToSet = LocalTime.of(hour, minute, second);
    this.dateAndTime = LocalDateTime.of(currentDate, timeToSet);
  }

  @Override
  public void setDate(int day, int month, int year) {
    LocalDate dateToSet = LocalDate.of(day, month, year);
    LocalTime currentTime = LocalTime.from(dateAndTime);
    this.dateAndTime = LocalDateTime.of(dateToSet, currentTime);
  }

  @Override
  public void setDateAndTime(int day, int month, int year, int hour, int minute, int second) {
    LocalDate dateToSet = LocalDate.of(day, month, year);
    LocalTime timeToSet = LocalTime.of(hour, minute, second);
    this.dateAndTime = LocalDateTime.of(dateToSet, timeToSet);
  }

  @Override
  public LocalDateTime getLocalDateTime() {
    return this.dateAndTime;
  }

  public String toString() {
    return this.dateAndTime.toString();
  }

  public static void main(String[] args) {
    TimeClient myTimeClient = new SimpleTimeClient();
    System.out.println(myTimeClient);
    System.out.println(myTimeClient.getZonedDateTime("Asia/Seoul"));
  }
}
