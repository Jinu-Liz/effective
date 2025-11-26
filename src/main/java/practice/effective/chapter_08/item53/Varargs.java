package practice.effective.chapter_08.item53;

public class Varargs {

  static int sum(int... args) {
    int sum = 0;
    for (int arg : args) {
      sum += arg;
    }

    return sum;
  }

  // 인수가 1개 이상이어야하는 가변인수 메서드 - 잘못 구현한 예
  static int min(int ...args) {
    if (args.length == 0) throw new IllegalArgumentException("No args");

    int min = args[0];
    for (int i = 1; i < args.length; i++) {
      if (args[i] < min) min = args[i];
    }

    return min;
  }

  // 인수가 1개 이상이어야 할 때는 첫번째 매개변수를 선언해버려서 인수가 없는 경우 에러를 발생시키면 된다.
  static int min(int firstArgs, int... remainingArgs) {
    int min = firstArgs;
    for (int arg : remainingArgs) {
      if (arg < min) min = arg;
    }

    return min;
  }

  public static void main(String[] args) {
    sum(); // 인수 없이 사용할 수도 있다. 이 점에 주의해야함.
    sum(1, 2, 3, 4);
  }
}
