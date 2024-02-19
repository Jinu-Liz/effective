package practice.effective.chapter_01.item_05;

import java.util.List;

public interface IDictionary {

  boolean contains(String word);

  List<String> closeWordsTo(String typo);

}
