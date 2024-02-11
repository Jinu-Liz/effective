package practice.effective.chapter_01.item_02.builder;

/**
 * 점층적 생성자 패턴. 확장하기 어렵다.
 * 코드 수는 줄일 수 있으나, 생성자를 사용할 때 어떤 파라미터를 주어야하는지 모른다.
 * (첫 번째가 servingSize였나? calories였나? 헷갈림)
 */
public class NutritionFactsChaining {

  private final int servingSize;    // (mL, 1회 제공량)     필수

  private final int serving;        // (회, 총 n회 제공량)   필수

  private final int calories;       // (1회 제공량당)        선택

  private final int fat;            // (g / 1회 제공량)     선택

  private final int sodium;         // (mg, 1회 제공량)     선택

  private final int carbohydrate;    // (g, 1회 제공량)     선택

  public NutritionFactsChaining(int servingSize, int serving) {
    this(servingSize, serving, 0);
  }

  public NutritionFactsChaining(int servingSize, int serving, int calories) {
    this(servingSize, serving, calories, 0);
  }

  public NutritionFactsChaining(int servingSize, int serving, int calories, int fat) {
    this(servingSize, serving, calories, fat, 0);
  }

  public NutritionFactsChaining(int servingSize, int serving, int calories, int fat, int sodium) {
    this(servingSize, serving, calories, fat, sodium, 0);
  }

  public NutritionFactsChaining(int servingSize, int serving, int calories, int fat, int sodium, int carbohydrate) {
    this.servingSize = servingSize;
    this.serving = serving;
    this.calories = calories;
    this.fat = fat;
    this.sodium = sodium;
    this.carbohydrate = carbohydrate;
  }
}
