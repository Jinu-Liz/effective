package practice.effective.chapter_01.item_03.perfect.functionalinterface;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class UsageOfFunctions {
  public static void main(String[] args) {
    List<LocalDate> dates = new ArrayList<>();
    dates.add(LocalDate.of(1982, 7, 14));
    dates.add(LocalDate.of(2020, 8, 24));
    dates.add(LocalDate.of(2013, 2, 11));

    Predicate<LocalDate> localDatePredicate = d -> d.isBefore(LocalDate.of(2000, 1, 1));
    Function<LocalDate, Integer> getYear = LocalDate::getYear;
    List<Integer> before2000 = dates.stream()
      .filter(localDatePredicate)
      .map(getYear)
      .toList();
  }
}
