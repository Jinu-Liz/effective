package practice.effective.chapter_01.item_05.factorymethod;

import practice.effective.chapter_01.item_05.IDictionary;

import java.util.List;

public class MockDictionary implements IDictionary {
  @Override
  public boolean contains(String word) {
    return false;
  }

  @Override
  public List<String> closeWordsTo(String typo) {
    return null;
  }
}
