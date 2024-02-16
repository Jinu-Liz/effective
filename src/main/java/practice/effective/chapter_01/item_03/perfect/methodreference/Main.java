package practice.effective.chapter_01.item_03.perfect.methodreference;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
  public static void main(String[] args) {
    List<Person> people = new ArrayList<>();
    people.add(new Person(LocalDate.of(1982, 7, 15)));
    people.add(new Person(LocalDate.of(2011, 3, 2)));
    people.add(new Person(LocalDate.of(2013, 1, 28)));

    people.sort(Person::compareByAge);

    Person person = new Person(null);
    people.sort(person::notStaticCompareByAge);

    Comparator<Person> compareByAge = Person::compareByAgeReferenceSelf;
    people.sort(compareByAge);
    Function<LocalDate, Person> aNew = Person::new;
    Supplier<Person> aNew2 = Person::new;
  }
}
