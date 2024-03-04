package practice.effective.chapter_01.item_08.autoclosable;

public class App {
  public static void main(String[] args) throws Exception {
    /**
     * try-resource가 권장된다.
     * cleaner의 경우, try-resource를 쓰지 않더라도
     * 자원을 반납할 수 있는 기회를 가질 수 있도록 하는 것에 의의가 있다. (안전망)
     */
    try(AutoClosableIsGood good = new AutoClosableIsGood()) {
      // TODO 자원 반납 처리가 됨.
    }
  }
}
