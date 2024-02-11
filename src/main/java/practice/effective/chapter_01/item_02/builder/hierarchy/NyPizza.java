package practice.effective.chapter_01.item_02.builder.hierarchy;

import java.util.Objects;

public class NyPizza extends Pizza {

  public enum Size { SMALL, MEDIUM, LARGE }

  private final Size size;

  public static class Builder extends Pizza.Builder<NyPizza.Builder> {

    private final Size size;

    public Builder(Size size) {
      this.size = Objects.requireNonNull(size);
    }

    @Override
    NyPizza build() {
      return new NyPizza(this);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }

  private NyPizza(Builder builder) {
    super(builder);
    this.size = builder.size;
  }

  @Override
  public String toString() {
    return toppings + "로 토핑한 피자";
  }
}
