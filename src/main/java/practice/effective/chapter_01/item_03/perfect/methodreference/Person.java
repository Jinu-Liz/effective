package practice.effective.chapter_01.item_03.perfect.methodreference;

import java.time.LocalDate;

public class Person {

  LocalDate birthday;

  public static int compareByAge(Person a, Person b) {
    return a.birthday.compareTo(b.birthday);
  }

  public int notStaticCompareByAge(Person a, Person b) {
    return a.birthday.compareTo(b.birthday);
  }

  public int compareByAgeReferenceSelf(Person b) {
    return this.birthday.compareTo(b.birthday);
  }

  public Person() {}

  public Person(LocalDate birthday) {
    this.birthday = birthday;
  }

  public int getAge() {
    return LocalDate.now().getYear() - birthday.getYear();
  }
}
