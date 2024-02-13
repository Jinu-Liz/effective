package practice.effective.chapter_01.item_02.builder.pattern;

import lombok.AllArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
public class TourDirector {

  private TourPlanBuilder tourPlanBuilder;

  /**
   * Builder를 사용하여 Plan생성
   */
  public TourPlan cancunTrip() {
    return tourPlanBuilder.title("칸쿤 여행")
      .nightsAndDays(2, 3)
      .startDate(LocalDate.of(2024, 3, 12))
      .whereToStay("리조트")
      .addPlan(0, "체크인하고 짐 풀기")
      .addPlan(1, "코끼리 투어")
      .getPlan();
  }

  public TourPlan longBeachTrip() {
    return tourPlanBuilder.title("롱비치")
      .startDate(LocalDate.of(2024, 7, 15))
      .getPlan();
  }
}
