package practice.effective.chapter_04.item_17.complex;

/**
 * 불변 클래스의 경우, 매개변수로 받은 값이 변하지 않기 때문에
 * 함수형 프로그래밍에 적합하다.
 * 또한, 값이 바뀌는 것에 대해 생각을 하지 않아도 되니 코딩이 단순해지고 쉬워진다.
 *
 * 변하지 않으니 멀티 쓰레드 환경에서 안심하고 공유할 수 있다.
 */
public class Complex {

  private final double re;

  private final double im;

  /**
   * 객체를 상수로 만들어서 공유해서 써도 안전하다.
   */
  public static final Complex ZERO = new Complex(0, 0);

  public static final Complex ONE = new Complex(1, 0);

  public static final Complex I = new Complex(0, 1);

  public Complex(double re, double im) {
    this.re = re;
    this.im = im;
  }

  public double realPart() {
    return this.re;
  }

  public double imaginaryPart() {
    return this.im;
  }

  /**
   * 유일한 단점은, 값을 변경하기 위해서는
   * 새로운 객체를 만들어야한다.
   * 비용이 큰 객체인 경우 성능 저하를 야기할 수 있다.
   *
   * 따라서 새로운 객체를 생성하는 여러 메서드를
   * 하나로 모아서 처리함으로써 이를 어느 정도 방지할 수 있다.
   */
  public Complex plus(Complex c) {
    return new Complex(re + c.re, im + c.im);
  }

  public static Complex valueOf(double re, double im) {
    return new Complex(re, im);
  }

  public Complex minus(Complex c) {
    return new Complex(re - c.re, im - c.im);
  }

  public Complex times(Complex c) {
    return new Complex(re * c.re - im * c.im, re * c.im + im * c.re);
  }

  public Complex divideBy(Complex c) {
    double tmp = c.re * c.re + c.im * c.im;

    return new Complex((re * c.re + im * c.im) / tmp, (im * c.re - re * c.im) / tmp);
  }
}
