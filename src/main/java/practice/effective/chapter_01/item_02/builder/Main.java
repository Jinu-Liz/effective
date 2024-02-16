package practice.effective.chapter_01.item_02.builder;

import practice.effective.chapter_01.item_02.perfect.javabeans.NutritionFactsJavaBeans;

public class Main {
  public static void main(String[] args) {

    /**
     * 일반적인 생성자 사용
     */
    NutritionFacts nutritionFacts = new NutritionFacts(240, 80, 100, 35, 8);

    /**
     * 기본값이 셋팅되지 않은 채로 사용될 수 있다. (servingSize 누락)
     * 또한 어느 값까지 셋팅해줘야 완전한 상태로 사용될 수 있는지 알 수 있는 방법이 없다.
     *
     * 객체를 만들기 쉽도록 매개변수 없는 생성자를 기본적으로 생성 가능하도록 해놓았다.
      */
    NutritionFactsJavaBeans factsJavaBeans = new NutritionFactsJavaBeans();
    factsJavaBeans.setServing(80);
    factsJavaBeans.setCalories(100);
    factsJavaBeans.setFat(35);
    factsJavaBeans.setSodium(8);
  }

  NutrionFactsBuilder nutrionFactsBuilder = new NutrionFactsBuilder.Builder(240, 8)
    .calories(100)
    .sodium(35)
    .carbohydrate(8)
    .build();

  NutrionFactsBuilderAnnotation nutrionFactsBuilderAnnotation = NutrionFactsBuilderAnnotation.builder()
    .calories(100)
    .sodium(35)
    .carbohydrate(8)
    .build();
}
