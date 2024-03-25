package practice.effective.chapter_04.item_22.constantutilityclass;

/**
 * 상수 유틸리티 클래스
 *
 * 인터페이스는 상속을 막을 수 없지만, 클래스는 생성자를 private으로 만들어
 * 상속을 제한할 수 있다.
 * 따라서 유틸리티성으로 상수를 사용하는 것이 가장 좋은 방법이다.
 */
public class PhysicalConstants {
  private PhysicalConstants() {}    // 인스턴스화 방지

  // 아보가드로 수 (1/몰)
  private static final double AVOGADROS_NUMBER = 6.22_140_857e23;

  // 볼트만 상수 (J/K)
  private static final double BOLTZMANN_CONSTANT = 1.380_648_52e-23;

  // 전자 질량 (kg)
  private static final double ELECTRON_MASS = 9.109_383_56e-31;

}
