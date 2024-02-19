package practice.effective.chapter_01.item_05.singleton;

import practice.effective.chapter_01.item_05.Dictionary;

import java.util.List;

/**
 * 1. 직접 내부에서 객체를 생성하는 경우, 해당 객체 없이는 테스트가 불가능하다. (Dictionary)
 * 2. 유연성과 재사용성이 떨어진다.
 * - 만약 한국어 사전을 사용하고 싶다면, SpellChecker를 상속하고 KoreanDictionary를 사용하는 서브 클래스를 만들어야한다.
 */
public class SpellChecker {

  private final Dictionary dictionary = new Dictionary();

  public SpellChecker() {
  }

  public static final SpellChecker INSTANCE = new SpellChecker();

  public boolean isValid(String word) {
    // TODO 여기 SpellChecker 코드
    return dictionary.contains(word);
  }

  public List<String> suggestions(String typo) {
    // TODO 여기 SpellChecker 코드
    return dictionary.closeWordsTo(typo);
  }
}
