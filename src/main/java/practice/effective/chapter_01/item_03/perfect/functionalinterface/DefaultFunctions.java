package practice.effective.chapter_01.item_03.perfect.functionalinterface;

import practice.effective.chapter_01.item_03.perfect.methodreference.Person;

import java.time.LocalDate;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class DefaultFunctions {
  public static void main(String[] args) {
    /**
     * Function
     * 타입 2개를 받아 입력/출력.
     * 어떻게 정의하느냐에 따라 타입이 입력이 될 수도, 출력이 될 수도 있다.
     */
    Function<Integer, String> intToString = Objects::toString;

    // LocalDate를 받는 생성자
    Function<LocalDate, Person> personFunction = Person::new;

    /**
     * Supplier
     * 받는 거 없이 나오는 거만 있는 경우. (기본 생성자)
     */
    Supplier<Person> integerSupplier = Person::new;

    /**
     * Consumer
     * 매개변수가 있으면서 반환 타입이 없는 경우(Void 메서드).
     */
    Consumer<Integer> integerConsumer = System.out::println;

    /**
     * Predicate
     * 매개변수를 받아서 Boolean을 리턴.
     */
    Predicate<Integer> predicate;
  }
}
