package practice.effective.chapter_04.item_22.constantinterface;

public class MyClass implements PhysicalConstants {

  /**
   * 인터페이스에 상수를 정의할 경우, 인터페이스명을 쓸 필요없이 변수명만 사용하면 된다.
   * 그러나, 편의성을 위하여 이렇게 쓰는 것은 안티 패턴으로, 권장되지 않는다.
   * 인터페이스의 가장 큰 의도는 타입을 정의하는 것이기 때문이다.
   *
   * MyClass는 PhysicalConstants 타입인가? 라고 하면 설계적으로 그렇지 않다.
   * MyClass는 그저 상수만 가져다 사용하고 있을 뿐이기 때문이다.
   *
   * 또한, MyClass에서 상수를 가져다 쓰기 때문에 해당 상수는 MyClass의 내부 정보이기도 하다.
   * 따라서 다른 곳에 내부 정보가 노출되어버리기 때문에 캡슐화가 깨져버린다.
   */
  public static void main(String[] args) {
    System.out.println(BOLTZMANN_CONSTANT);

    /**
     * 이렇게 사용하는 것인가? 라는 혼란을 줄 수 있다.
     */
    PhysicalConstants myClass = new MyClass();
  }
}
