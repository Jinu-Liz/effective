package practice.effective.chapter_01.item_05.springioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import practice.effective.chapter_01.item_05.IDictionary;

@Configuration
public class AppConfig {

//  @Bean
  public SpellChecker spellChecker(IDictionary dictionary) {
    return new SpellChecker(dictionary);
  }

//  @Bean
  public IDictionary dictionary() {
    return new SpringDictionary();
  }

}
