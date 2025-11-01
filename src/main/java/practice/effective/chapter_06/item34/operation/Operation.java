package practice.effective.chapter_06.item34.operation;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operation {

  PLUS("+") {
    public double apply(double x, double y) { return x + y; }
  },
  MINUS("-") {
    public double apply(double x, double y) { return x - y; }
  },
  TIMES("*") {
    public double apply(double x, double y) { return x * y; }
  },
  DIVIDE("/") {
    public double apply(double x, double y) { return x / y; }
  };

  private final String symbol;

  Operation(String symbol) {
    this.symbol = symbol;
  }

  @Override
  public String toString() {
    return symbol;
  }

  // 추상 메서드를 사용하여 구현을 강제할 수 있다.
  public abstract double apply(double x, double y);

  private static final Map<String, Operation> stringToEnum =
    Stream.of(values())
      .collect(Collectors.toMap(Object::toString, e -> e));

  /**
   * 문자열을 통해 Enum을 반환하기 위한 메서드를 정의해주는 것이 권장된다.
   * "+" -> Operation.PLUS
   */
  public static Optional<Operation> fromString(String symbol) {
    return Optional.ofNullable(stringToEnum.get(symbol));
  }

  public static void main(String[] args) {
    double x = 10;
    double y = 5;
    for (Operation op : Operation.values()) {
      System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
    }
  }
}
