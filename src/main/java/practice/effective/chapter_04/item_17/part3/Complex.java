package practice.effective.chapter_04.item_17.part3;

public class Complex {

  private final double re;

  private final double im;

  public static final Complex ZERO = new Complex(0, 0);

  public static final Complex ONE = new Complex(1, 0);

  public static final Complex I = new Complex(0, 1);

  /**
   * private 또는 package-private 생성자를 사용하여
   * 상속을 막는다.
   */
  private Complex(double re, double im) {
    this.re = re;
    this.im = im;
  }

  /**
   * 내부에 구현체를 만들면, private 상태에서
   * public 메서드를 이용하여 내부 구현체를 바꿀 수 있다.
   * 이를 Client에게 숨길 수 있다.
   */
  private static class MyComplex extends Complex {
    public MyComplex(double re, double im) {
      super(re, im);
    }
  }

  // 정적 팩터리(private 생성자와 함께 사용)
  public static Complex valueOf(double re, double im) {
    return new MyComplex(re, im);
  }

  public double realPart() {
    return this.re;
  }

  public double imaginaryPart() {
    return this.im;
  }

  public Complex plus(Complex c) {
    return new Complex(re + c.re, im + c.im);
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
