package practice.effective.chapter_08.item53;

import practice.effective.chapter_06.item36.best_practice.Text;

import java.util.EnumSet;

/**
 * 가변인수의 경우, 많이 사용되는 경우에 성능저하를 야기할 수 있다.
 * 호출될 때마다 배열을 생성/할당/초기화 하는 과정이 일어나기 때문.
 * 따라서, 성능에 민감한 경우에는 매개변수를 여러 개 받는 메서드를 다중정의 하는 게 좋다.
 */
public class EnumSetExample {
  public static void main(String[] args) {
    // 매개변수 1~5개까지의 메서드를 각각 만들어놓고, 그 이상의 경우에는 가변인수로 만들어 놓는다.
    EnumSet.of(Text.Style.BOLD);
    EnumSet.of(Text.Style.BOLD, Text.Style.ITALIC);
    EnumSet.of(Text.Style.BOLD, Text.Style.ITALIC, Text.Style.UNDERLINE);
  }
}
