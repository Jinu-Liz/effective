package practice.effective.chapter_01.item_02.builder.javabeans;

import lombok.Data;

import java.io.Serializable;

/**
 * 자바빈즈 패턴 - 일관성이 깨지고, 불변으로 만들 수 없다.
 * 자바빈(JavaBean)이 지켜야할 규약
 * 1. argument 없는 기본 생성자
 * 2. getter/setter 메소드 이름 규약
 * 3. Serializable 인터페이스 규약
  */
@Data
public class NutritionFactsJavaBeans implements Serializable {
  // 필드(기본값이 있다면) 기본값으로 초기화 된다.
  private int servingSize = -1;    // (mL, 1회 제공량)     필수

  private int serving = -1;        // (회, 총 n회 제공량)   필수

  private int calories = 0;        // (1회 제공량당)        선택

  private int fat = 0;             // (g / 1회 제공량)     선택

  private int sodium = 0;          // (mg, 1회 제공량)     선택

  private int carbohydrate = 0;    // (g, 1회 제공량)     선택

  private boolean healthy;

}
