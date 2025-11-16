package practice.effective.chapter_06.item34.operation;

import java.util.HashMap;
import java.util.Map;

public class OperationClass {

  private final static OperationClass PLUS = new OperationClass();

  private final static Map<String, OperationClass> stringToEnum = new HashMap<>();

  // enum이 아닌 클래스에서는 생성자를 만들 때 static 변수 접근 가능
  private OperationClass() {
    System.out.println(PLUS.toString());
    stringToEnum.put("+", PLUS);
  }

}
