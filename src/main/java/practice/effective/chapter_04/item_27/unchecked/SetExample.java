package practice.effective.chapter_04.item_27.unchecked;

import java.util.HashSet;
import java.util.Set;

public class SetExample {
  public static void main(String[] args) {
    /**
     * 동작은 하지만, 타입이 정해지지 않아
     * 에러가 발생할 확률이 있으므로 unchecked 경고가 발생한다.
     */
    Set names = new HashSet();

    /**
     * HashSet의 타입을 정해주지 않아 경고 발생
     */
    Set<String> strings = new HashSet();
  }
}
