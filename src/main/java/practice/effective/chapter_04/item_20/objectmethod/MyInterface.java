package practice.effective.chapter_04.item_20.objectmethod;

/**
 * default 메서드는 기존 인터페이스를 사용하는 클래스들에
 * 영향을 끼치지 않고 간단한 메서드를 추가하는 것을 목적으로 만들어졌다.
 *
 * 인터페이스 규칙
 * 1. 언제나 클래스가 인터페이스를 이긴다.
 * 2. 구체적인 인터페이스가 덜 구체적인 인터페이스를 이긴다. (서브 인터페이스가 이긴다.)
 *
 * 그런데 default에서 Object의 메서드를 구현하는 순간,
 * Class의 메서드를 따라야하는지, 인터페이스의 메서드를 따라야하는지 알 수 없어진다.
 *
 * 또한, 인터페이스에서 변경해버리면 하위 계층 클래스의 기능이 바뀌어버리니
 * 하위 계층 클래스 입장에서는 갑자기 기능이 바뀌어 당황스러워질 것이다.
 */
public interface MyInterface {

  default String toString() {
    return "myString";
  }

  default int hashCode() {
    return 10;
  }

  default boolean equals(Object o) {
    return true;
  }

}
