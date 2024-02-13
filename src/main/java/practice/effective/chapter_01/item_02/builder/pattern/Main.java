package practice.effective.chapter_01.item_02.builder.pattern;

import java.time.LocalDate;

public class Main {
  public static void main(String[] args) {
    /**
     * 기존의 경우, TourPlan을 생성하려면 setter로 일일이 셋팅해주어 코드가 길어짐
     */
    TourPlan shortTrip = new TourPlan();
    shortTrip.setTitle("오레곤 롱비치 여행");
    shortTrip.setStartDate(LocalDate.of(2024, 7, 12));

    TourPlan tourPlan = new TourPlan();
    tourPlan.setTitle("칸쿤 여행");
    tourPlan.setNights(2);
    tourPlan.setDays(3);
    tourPlan.setStartDate(LocalDate.of(2024, 12, 24));
    tourPlan.setWhereToStay("리조트");
    tourPlan.addPlan(0, "체크인 이후 짐풀기");
    tourPlan.addPlan(0, "저녁 식사");
    tourPlan.addPlan(1, "해변가 산책");
    tourPlan.addPlan(1, "BBQ 스테이크");
    tourPlan.addPlan(2, "체크아웃");


    TourDirector director = new TourDirector(new DefaultTourBuilder());
    TourPlan cancunTrip = director.cancunTrip();
    TourPlan longBeachTrip = director.longBeachTrip();
  }
}
