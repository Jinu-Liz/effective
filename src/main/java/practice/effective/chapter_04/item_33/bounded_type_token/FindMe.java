package practice.effective.chapter_04.item_33.bounded_type_token;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
public @interface FindMe {
}
