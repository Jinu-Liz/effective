package practice.effective.chapter_01.item_02.builder;

/**
 * 빌더 패턴. 점층적 생성자 패턴과 자바빈즈 패턴의 장점만 취했다.
 * 필수 속성을 설정할 수 있어, 자바빈즈보다 훨씬 안전하게 만들 수 있다.
 *
 * 그러나 모든 상황에서 builder가 좋은 것은 아니다.
 * 코드가 복잡해지고, 중복된 필드를 선언하는 등의 역효과가 있다.
 *
 * 1. 필수값과 선택값이 나누어져 있고, 이 때문에 생성자의 매개변수가 너무 많이 늘어날 때
 * 2. immutable하게 만들고 싶을 때
 * 사용하면 좋다.
  */
public class NutrionFactsBuilder {

  private final int servingSize;    // (mL, 1회 제공량)     필수

  private final int serving;        // (회, 총 n회 제공량)   필수

  private final int calories;       // (1회 제공량당)        선택

  private final int fat;            // (g / 1회 제공량)     선택

  private final int sodium;         // (mg, 1회 제공량)     선택

  private final int carbohydrate;    // (g, 1회 제공량)     선택

  public static class Builder {

    private final int servingSize;

    private final int servings;

    private int calories = 0;

    private int fat = 0;

    private int sodium = 0;

    private int carbohydrate = 0;

    /**
     * setter가 Builder 자신을 return함으로써 method chaining이 가능하다.
     */
    public Builder(int servingSize, int servings) {
      this.servingSize = servingSize;
      this.servings = servings;
    }

    public Builder calories(int calories) {
      this.calories = calories;
      return this;
    }

    public Builder fat(int fat) {
      this.fat = fat;
      return this;
    }

    public Builder sodium(int sodium) {
      this.sodium = sodium;
      return this;
    }

    public Builder carbohydrate(int carbohydrate) {
      this.carbohydrate = carbohydrate;
      return this;
    }

    public NutrionFactsBuilder build() {
      return new NutrionFactsBuilder(this);
    }
  }

  public NutrionFactsBuilder(Builder builder) {
   this.servingSize = builder.servingSize;
   this.serving = builder.servings;
   this.calories = builder.calories;
   this.fat = builder.fat;
   this.sodium = builder.sodium;
   this.carbohydrate = builder.carbohydrate;
  }
}
