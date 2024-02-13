package practice.effective.chapter_01.item_02.builder.pattern;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class TourPlan {

  private String title;

  private int nights;

  private List<DetailPlan> plans;
}
