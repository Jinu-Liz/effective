package practice.effective.chapter_01.item_02.builder.hierarchy;

public class Calzone extends Pizza {

  private final boolean sauceInside;

  public static class Builder extends Pizza.Builder<Calzone.Builder> {

    private boolean sauceInside = false;

    public Builder sauceInside() {
      this.sauceInside = true;

      return this;
    }

    @Override
    Calzone build() {
      return new Calzone(this);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }

  Calzone(Builder builder) {
    super(builder);
    this.sauceInside = builder.sauceInside;
  }

  @Override
  public String toString() {
    return String.format("%s로 토핑한 칼초네 피자 (소스는 %s에)", this.toppings, this.sauceInside ? "안" : "바깥");
  }
}
