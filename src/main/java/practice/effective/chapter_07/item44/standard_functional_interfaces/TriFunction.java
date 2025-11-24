package practice.effective.chapter_07.item44.standard_functional_interfaces;

/**
 * 함수형 인터페이스
 * 1. 자주 쓰일 때 정의하여 사용하면 좋다.
 * 2. 이름 자체가 용도를 명확히 설명해줄 수 있는 장점이 있다.
 * 3. 반드시 따라야하는 규약이 있다.
 * 4. 유용한 디폴트 메서드를 제공할 수 있다.
 * 5. 람다용으로 설계된 것임을 알려준다.
 * 6. 해당 인터페이스가 추상 메서드를 오직 하나만 가지고 있어야 컴파일 되게 해준다.
 * 7. 유지보수 과정에서 누군가 실수로 메서드를 추가하지 못하게 막아준다.
 */
@FunctionalInterface
public interface TriFunction<T, U, V, R> {

  R apply(T t, U u, V v);

}
