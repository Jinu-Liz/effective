package practice.effective.chapter_06.item38;

// 인터페이스를 이용하여 확장 가능 열거 타입을 흉내냄
public enum BasicOperation implements Operation {

  PLUS("+") {
    public double apply(double a, double b) { return a + b; }
  },

  MINUS("-") {
    public double apply(double a, double b) { return a - b; }
  },

  TIMES("*") {
    public double apply(double a, double b) { return a * b; }
  },

  DIVIDE("/") {
    public double apply(double a, double b) { return a / b; }
  };

  private final String symbol;

  BasicOperation(String symbol) {
    this.symbol = symbol;
  }

  @Override
  public String toString() {
    return this.symbol;
  }
}
