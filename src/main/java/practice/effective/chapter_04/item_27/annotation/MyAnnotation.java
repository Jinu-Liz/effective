package practice.effective.chapter_04.item_27.annotation;

import java.lang.annotation.*;

/**
 * @Documented 를 사용하면 javaDoc을 만들 때, 어노테이션 정보가 포함 됨.
 *
 * @Retention 은 이 어노테이션의 정보를 언제까지 참조할 수 있도록 할 것이냐.
 * RUNTIME - 런타임 중에도 이용할 수 있게 한다.
 * CLASS - Class파일에서 까지만 참조할 수 있게하고, 런타임 중에는 참조할 수 없게끔 하겠다.
 * SOURCE - 소스 코드의 이해를 돕기 위한 주석같은 역할을 한다.
 *
 * @Target 은 해당 어노테이션을 사용할 수 있는 범위
 * TYPE - 클래스 타입
 * METHOD - 메서드
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
public @interface MyAnnotation {
}
