package practice.effective.chapter_06.item38;

import java.util.Arrays;
import java.util.Collection;

// 확장 가능 열거 타입
public enum ExtendedOperation implements Operation {

  EXP("^") {
    public double apply(double x, double y) { return Math.pow(x, y); }
  },

  REMAINDER("%") {
    public double apply(double x, double y) { return x % y; }
  };

  private final String symbol;

  ExtendedOperation(final String symbol) {
    this.symbol = symbol;
  }

  @Override
  public String toString() {
    return this.symbol;
  }

  public static void main(String[] args) {
    double x = 10;
    double y = 5;

    test(ExtendedOperation.class, x, y);
    testCollection(Arrays.asList(BasicOperation.values()), x, y);
  }

  // enum이면서 operation인 타입
  private static <T extends Enum<T> & Operation> void test(Class<T> enumType, double x, double y) {
    for (Operation operation : enumType.getEnumConstants()) {
      System.out.printf("%f %s %f = %f%n", x, operation, y, operation.apply(x, y));
    }
  }

  // Collection을 사용했을 때
  private static void testCollection(Collection<? extends Operation> opSet, double x, double y) {
    for (Operation operation : opSet) {
      System.out.printf("%f %s %f = %f%n", x, operation, y, operation.apply(x, y));
    }
  }
}
