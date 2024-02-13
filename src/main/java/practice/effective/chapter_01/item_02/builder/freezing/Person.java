package practice.effective.chapter_01.item_02.builder.freezing;

import java.util.ArrayList;
import java.util.List;

// 클래스에 final을 붙이면 상속을 막을 수 있다.
public final class Person {

  private final String name;

  private final int birthYear;

  private final List<String> kids;

  public Person(String name, int birthYear) {
    this.name = name;
    this.birthYear = birthYear;
    this.kids = new ArrayList<>();
  }

  public static void main(String[] args) {
    final Person person = new Person("jinuliz", 1920);

    // final로 선언하였기 때문에 변경이 불가능하다.
//    person.name = "jilinuz";
  }
}
