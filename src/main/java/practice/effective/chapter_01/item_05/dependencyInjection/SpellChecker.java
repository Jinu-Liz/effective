package practice.effective.chapter_01.item_05.dependencyInjection;

import practice.effective.chapter_01.item_05.IDictionary;

import java.util.List;

/**
 * 의존성을 주입받으면 모든 코드를 재사용 가능하다.
 * 단, Dictionary가 인터페이스였을 경우.
 */
public class SpellChecker {

  private final IDictionary dictionary;

  public SpellChecker(IDictionary dictionary) {
    this.dictionary = dictionary;
  }

  public boolean isValid(String word) {
    // TODO 여기 SpellChecker 코드
    return dictionary.contains(word);
  }

  public List<String> suggestions(String typo) {
    // TODO 여기 SpellChecker 코드
    return dictionary.closeWordsTo(typo);
  }
}
