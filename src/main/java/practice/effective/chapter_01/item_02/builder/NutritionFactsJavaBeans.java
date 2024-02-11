package practice.effective.chapter_01.item_02.builder;

import lombok.Data;

// 자바빈즈 패턴 - 일관성이 깨지고, 불변으로 만들 수 없다.
@Data
public class NutritionFactsJavaBeans {
  // 필드(기본값이 있다면) 기본값으로 초기화 된다.
  private int servingSize = -1;    // (mL, 1회 제공량)     필수

  private int serving = -1;        // (회, 총 n회 제공량)   필수

  private int calories = 0;        // (1회 제공량당)        선택

  private int fat = 0;             // (g / 1회 제공량)     선택

  private int sodium = 0;          // (mg, 1회 제공량)     선택

  private int carbohydrate = 0;    // (g, 1회 제공량)     선택

}
