package practice.effective.chapter_01.item_02.builder.pattern;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class TourPlan {

  private String title;

  private int nights;

  private int days;

  private LocalDate startDate;

  private String whereToStay;

  private List<DetailPlan> plans;

  public TourPlan() {}

  public TourPlan(String title, int nights, List<DetailPlan> plans) {
    this.title = title;
    this.nights = nights;
    this.plans = plans;
  }

  public void addPlan(int day, String plan) {
    this.plans.add(new DetailPlan(day, plan));
  }
}
