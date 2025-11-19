package practice.effective.chapter_06.item39.annotation_with_parameter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 명시한 예외를 던져야지만 성공
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExceptionTest {

  Class<? extends Throwable> value();

}
