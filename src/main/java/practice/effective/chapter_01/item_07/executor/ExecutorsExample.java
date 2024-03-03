package practice.effective.chapter_01.item_07.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsExample {
  public static void main(String[] args) {
    int numberOfCpu = Runtime.getRuntime().availableProcessors();
    /**
     * newFixedThreadPool의 경우, Blocking Queue를 사용한다.
     * 이를 통해 동시성을 제어할 수 있다.
     *
     * newCachedThreadPool은 놀고 있는 Thread가 있는 경우, 가져다 쓴다.
     * 그러나 Thread가 없을 경우, 새로 만들기 때문에 무한하게 늘어날 수 있는 위험이 있어 조심히 써야한다.
     *
     * newSingleThreadExecutor은 Thread를 하나만 만든다.
     */
    ExecutorService service = Executors.newFixedThreadPool(numberOfCpu);
    ExecutorService service2 = Executors.newCachedThreadPool();
    ExecutorService service3 = Executors.newSingleThreadExecutor();
    ExecutorService service4 = Executors.newScheduledThreadPool(10);

    for (int i = 0; i < 100; i++) {
      service.submit(new Task());
//      Thread thread = new Thread(new Task());
//      thread.start();
    }

    System.out.println(Thread.currentThread() + " hello");

    service.shutdown();
  }

  static class Task implements Runnable {

    @Override
    public void run() {
      try {
        Thread.sleep(2000L);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      System.out.println(Thread.currentThread() + " world");
    }
  }

}
