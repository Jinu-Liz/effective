package practice.effective.chapter_01.item_05;

import org.junit.jupiter.api.Test;
import practice.effective.chapter_01.item_05.dependencyInjection.SpellChecker;

class SpellCheckerTest {

  @Test
  void isValid() {
    // 클라이언트 쪽에서 의존성을 주입. 다른 dictionary로 얼마든지 교체 가능
    SpellChecker spellChecker = new SpellChecker(new Dictionary());
    spellChecker.isValid("test");

    // supplier 사용
    SpellChecker spellChecker1 = new SpellChecker(Dictionary::new);
  }
}