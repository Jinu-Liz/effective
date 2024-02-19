package practice.effective.chapter_01.item_05.staticutils;

import practice.effective.chapter_01.item_05.Dictionary;

import java.util.List;

/**
 * SpellChecker의 기능을 사용하기 위해서는 dictionary를 사용해야한다.
 */
public class SpellChecker {

  // 자원을 직접 명시 = 자원을 직접 생성
  public static final Dictionary dictionary = new Dictionary();

  public SpellChecker() {
  }

  public static boolean isValid(String word) {
    // TODO 여기 SpellChecker 코드
    return dictionary.contains(word);
  }

  public static List<String> suggestions(String typo) {
    // TODO 여기 SpellChecker 코드
    return dictionary.closeWordsTo(typo);
  }
}
