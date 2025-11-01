package practice.effective.chapter_06.item34.operation;

public enum OperationOrigin {

  PLUS, MINUS, TIMES, DIVIDE;

  public double apply(double x, double y) {
    return switch (this) {
      case PLUS -> x + y;
      case MINUS -> x - y;
      case TIMES -> x * y;
      case DIVIDE -> x / y;
    };
  }

  /**
   * 이 경우, 새로운 enum이 추가되어도 처리를 깜빡하고 넘어갈 수 있다.
   */
  public double applyOld(double x, double y) {
    switch (this) {
      case PLUS: return x + y;
      case MINUS: return x - y;
      case TIMES: return x * y;
      case DIVIDE: return x / y;
    }

    throw new IllegalArgumentException("not supported operation");
  }
}
