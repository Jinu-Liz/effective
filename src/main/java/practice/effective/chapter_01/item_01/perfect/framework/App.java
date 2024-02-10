package practice.effective.chapter_01.item_01.perfect.framework;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import practice.effective.chapter_01.item_01.staticfactory.good.HelloServiceEx;

/**
 * 서비스 접근 API
 * 서비스를 가져오는 방법.
 */
public class App {
  public static void main(String[] args) {
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    HelloServiceEx helloServiceEx = applicationContext.getBean(HelloServiceEx.class);
    System.out.println(helloServiceEx.hello());
  }
}
