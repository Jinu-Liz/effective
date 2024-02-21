package practice.effective.chapter_01.item_05.factorymethod;

import practice.effective.chapter_01.item_05.IDictionary;

public class DefaultDictionaryFactory implements DictionaryFactory {

  @Override
  public IDictionary getDictionary() {
    return new DefaultDictionary();
  }
}
