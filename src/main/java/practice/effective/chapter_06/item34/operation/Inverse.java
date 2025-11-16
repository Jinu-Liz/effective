package practice.effective.chapter_06.item34.operation;

public class Inverse {
  public static Operation inverse(Operation operation) {
    switch (operation) {
      case PLUS:
        return Operation.MINUS;
      case MINUS:
        return Operation.PLUS;
      case TIMES:
        return Operation.TIMES;
      case DIVIDE:
        return Operation.DIVIDE;
      default:
        throw new AssertionError("Unknown op: " + operation);
    }
  }
}
