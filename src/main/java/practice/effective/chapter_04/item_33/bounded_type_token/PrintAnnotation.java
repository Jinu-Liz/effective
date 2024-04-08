package practice.effective.chapter_04.item_33.bounded_type_token;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

// asSubclass를 사용해 한정적 타입 토큰을 안전하게 형변환한다.
public class PrintAnnotation {

  static Annotation getAnnotation(AnnotatedElement element, String annotationTypeName) {
    Class<?> annotationType = null;   // 비한정적인 타입 토큰
    try {
      annotationType = Class.forName(annotationTypeName);
    } catch (Exception ex) {
      throw new IllegalArgumentException(ex);
    }

    // 한정적 와일드카드
    Class<? extends Annotation> aClass = annotationType.asSubclass(Annotation.class);
    return element.getAnnotation(aClass);
  }

  // 명시한 클래스의 명시한 어노테이션을 출력하는 테스트 프로그램
  public static void main(String[] args) {
    System.out.println(getAnnotation(MyService.class, FindMe.class.getName()));
  }
}
