package practice.effective.chapter_01.item_02.builder.hierarchy;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * 계층적으로 설계된 클래스와 잘 어울리는 필더 패턴
 */
public abstract class Pizza {

  public enum Topping { HAM, MUSHROOM, ONION, PEPPER, SAUSAGE }

  final Set<Topping> toppings;

  abstract static class Builder<T extends Builder<T>> {
    EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

    /**
     * self를 통해, 하위 계층의 Builder가 자기 자신의 타입을 반환하게하여
     * 각자에서 선언된 메서드를 사용할 수 있도록 유연함을 가지게 된다.
     */
    public T addTopping(Topping topping) {
      this.toppings.add(Objects.requireNonNull(topping));

      return self();
    }

    abstract Pizza build();

    // 하위 클래스는 이 메서드를 재정의(override)하여 "this"를 반환하도록 해야 한다.
    protected abstract T self();
  }

  Pizza(Builder<?> builder) {
    toppings = builder.toppings.clone();
  }
}
