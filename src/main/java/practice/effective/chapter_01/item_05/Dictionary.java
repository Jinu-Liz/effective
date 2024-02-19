package practice.effective.chapter_01.item_05;

import java.util.ArrayList;
import java.util.List;

public class Dictionary implements IDictionary {

  @Override
  public boolean contains(String word) {
    return true;
  }

  @Override
  public List<String> closeWordsTo(String typo) {
    return new ArrayList<>();
  }
}
