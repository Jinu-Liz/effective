package practice.effective.chapter_01.item_05.springioc;

import org.springframework.stereotype.Component;
import practice.effective.chapter_01.item_05.IDictionary;

import java.util.List;

@Component
public class SpringDictionary implements IDictionary {

  @Override
  public boolean contains(String word) {
    System.out.println("contains " + word);
    return false;
  }

  @Override
  public List<String> closeWordsTo(String typo) {
    return null;
  }
}
