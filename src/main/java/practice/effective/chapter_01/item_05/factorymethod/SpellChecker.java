package practice.effective.chapter_01.item_05.factorymethod;

import practice.effective.chapter_01.item_05.IDictionary;

import java.util.List;

public class SpellChecker {

  private final IDictionary dictionary;

  /**
   * dictionary를 얼마든지 늘릴 수 있으므로, 확장에 열려있다.
   * 그러나, 코드를 변경하지 않아도 되므로 변경에 닫혀있다.
   *
   * 이렇게 인터페이스로 만들어야 변경하지 않고 테스트도 가능하며,
   * 재사용에도 용이하다.
   */
  public SpellChecker(DictionaryFactory dictionaryFactory) {
    this.dictionary = dictionaryFactory.getDictionary();
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
