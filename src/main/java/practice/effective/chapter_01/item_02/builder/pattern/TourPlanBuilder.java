package practice.effective.chapter_01.item_02.builder.pattern;

import java.time.LocalDate;

public interface TourPlanBuilder {

  TourPlanBuilder nightsAndDays(int nights, int days);

  TourPlanBuilder title(String title);

  TourPlanBuilder startDate(LocalDate localDate);

  TourPlanBuilder whereToStay(String whereToStay);

  TourPlanBuilder addPlan(int day, String plan);

  TourPlan getPlan();

}
