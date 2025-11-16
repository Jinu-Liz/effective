package practice.effective.chapter_06.item34.operation;

import java.util.HashMap;
import java.util.Map;

public enum OperationOrigin {

  PLUS, MINUS, TIMES, DIVIDE;

  /**
   * enum에서는 생성자가 호출되는 시점에는 정적인 필드들이 초기화 되지 않은 상태이다.
   * 따라서 enum 상수에도 접근할 수 없다.
   */
  private static final Map<String, OperationOrigin> stringToEnum = new HashMap<>();

//  OperationOrigin(String sign) {
//    // 초기화되지 않은 상태이기 때문에 접근할 수 없음
//    stringToEnum.put(sign, this);
//    System.out.println(OperationOrigin.PLUS);
//  }

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
