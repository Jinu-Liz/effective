package practice.effective.chapter_01.item_05.springioc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = AppComponentScanConfig.class)
public class AppComponentScanConfig {
}
