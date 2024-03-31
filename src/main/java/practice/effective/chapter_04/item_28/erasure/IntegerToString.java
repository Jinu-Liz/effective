package practice.effective.chapter_04.item_28.erasure;

import java.util.ArrayList;
import java.util.List;

public class IntegerToString {
  public static void main(String[] args) {

    /**
     * 공변
     * 최상위 타입인 Object 타입이니 String 타입을 담을 수 있다.
     */
    Object[] anything = new String[10];
    anything[0] = 1;  // 해당 코드는 문제가 있으나, 정상인 것처럼 보인다.

    /**
     * 불공변
     * Generic은 불공변이다.
     * 타입의 상하관계를 따지지 않는다.
     */
    List<String> names = new ArrayList<>();
//    List<Object> objects = names;   // 타입 상하관계와 관계없이 서로 다르므로 에러가 발생한다.

  }
}
