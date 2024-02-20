package practice.effective.chapter_01.item_05.dependencyInjection;

import practice.effective.chapter_01.item_05.IDictionary;

import java.util.List;
import java.util.function.Supplier;

/**
 * 의존성을 주입받으면 모든 코드를 재사용 가능하다.
 * 단, Dictionary가 인터페이스였을 경우.
 */
public class SpellChecker {

  private final IDictionary dictionary;

  public SpellChecker(IDictionary dictionary) {
    this.dictionary = dictionary;
  }

  // factory를 통해 자원을 받아옴. 팩토리 메서드 패턴
  public SpellChecker(DictionaryFactory factory) {
    this.dictionary = factory.get();
  }

  public SpellChecker(Supplier<IDictionary> supplier) {
    this.dictionary = supplier.get();
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
