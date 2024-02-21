package practice.effective.chapter_01.item_05.springioc;

import org.springframework.stereotype.Component;
import practice.effective.chapter_01.item_05.IDictionary;

import java.util.List;

/**
 * Spring은 자신의 코드가 노출되기를 원하지 않는다.(비 침투적)
 * 따라서, 프레임워크와 관련된 무언가를 상속받는다던가
 * 특정 메서드를 사용해야하는 것을 제외한 코드를 원한다. (POJO)
 */
@Component
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
