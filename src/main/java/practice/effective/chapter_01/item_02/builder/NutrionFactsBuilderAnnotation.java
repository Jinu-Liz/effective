package practice.effective.chapter_01.item_02.builder;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;

/**
 * Builder 어노테이션만 사용할 경우, 모든 필드를 주입받는 생성자가 생겨버린다.
 * 따라서 이게 싫으면 private으로 막으면 된다.
 * 현재까지는 Builder어노테이션으로는 필수값을 받는 처리를 못하기 때문에 이럴 경우에는
 * 별도로 Builder를 만들어 사용한다.
 */
@Builder(builderClassName = "Builder")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class NutrionFactsBuilderAnnotation {

  private final int servingSize;    // (mL, 1회 제공량)     필수

  private final int serving;        // (회, 총 n회 제공량)   필수

  private final int calories;       // (1회 제공량당)        선택

  private final int fat;            // (g / 1회 제공량)     선택

  private final int sodium;         // (mg, 1회 제공량)     선택

  private final int carbohydrate;    // (g, 1회 제공량)     선택

}
