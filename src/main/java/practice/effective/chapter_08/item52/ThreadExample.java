package practice.effective.chapter_08.item52;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadExample {

  public static void main(String[] args) {
    new Thread(System.out::println).start();

    ExecutorService executorService = Executors.newCachedThreadPool();
//    executorService.submit(System.out::println);  // 다중정의를 사용하기 때문에 타입을 알 수 없어 에러.
  }
}
