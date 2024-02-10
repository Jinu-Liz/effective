package practice.effective.chapter_01.item_01.perfect.framework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import practice.effective.chapter_01.item_01.staticfactory.ChineseHelloService;
import practice.effective.chapter_01.item_01.staticfactory.good.HelloServiceEx;

/**
 * 서비스 제공자 등록 API
 * Configuration 어노테이션으로 등록 Class를 지정 후,
 * Bean 어노테이션을 이용하여 서비스 구현체를 등록한다.
 */
@Configuration
public class AppConfig {

  @Bean
  public HelloServiceEx helloService() {
    return new ChineseHelloService();
  }

}
