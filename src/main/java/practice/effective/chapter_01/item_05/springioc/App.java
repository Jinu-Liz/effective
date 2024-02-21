package practice.effective.chapter_01.item_05.springioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
  public static void main(String[] args) {

    /**
     * SpellChecker를 new를 통해 생성하면, 스프링이 모르는 객체이다.
     * 따라서, 스프링 컨테이너에 등록된 Bean을 꺼내어 쓰면 싱글턴으로 사용할 수 있으며
     * SpellChecker와 SpringDictionary에 프레임워크 코드를 노출시키지 않는다.
     */
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppComponentScanConfig.class);
    SpellChecker spellChecker = applicationContext.getBean(SpellChecker.class);
    spellChecker.isValid("test");
  }
}
