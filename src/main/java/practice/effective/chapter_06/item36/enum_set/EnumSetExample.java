package practice.effective.chapter_06.item36.enum_set;

import practice.effective.chapter_06.item36.best_practice.Text;

import java.util.EnumSet;

import static practice.effective.chapter_06.item36.best_practice.Text.Style.*;

public class EnumSetExample {

  public static void main(String[] args) {
    EnumSet<Text.Style> styles = EnumSet.of(BOLD, ITALIC);

    Text.Style[] values = Text.Style.values();

    // 해당 Enum 타입의 모든 상수를 담은 EnumSet 만들기
    EnumSet<Text.Style> styles1 = EnumSet.allOf(Text.Style.class);
    System.out.println(styles1);

    // 비어있는 EnumSet 만들기
    EnumSet<Text.Style> styles2 = EnumSet.noneOf(Text.Style.class);
    System.out.println(styles2);

    // 정의된 순서에 따름
    EnumSet<Text.Style> styles3 = EnumSet.range(BOLD, UNDERLINE);
    System.out.println(styles3);

    System.out.println(styles3.contains(BOLD));
    styles3.forEach(System.out::println);

    EnumSet<Text.Style> styles4 = EnumSet.complementOf(styles3);
    System.out.println(styles4);

    boolean remove = styles3.remove(BOLD);
    System.out.println(remove);
  }
}
