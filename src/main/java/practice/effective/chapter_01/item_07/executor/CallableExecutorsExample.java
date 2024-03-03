package practice.effective.chapter_01.item_07.executor;

import java.util.concurrent.*;

public class CallableExecutorsExample {
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    int numberOfCpu = Runtime.getRuntime().availableProcessors();

    ExecutorService service = Executors.newFixedThreadPool(numberOfCpu);

    Future<String> submit = service.submit(new Task());

    System.out.println(Thread.currentThread() + " hello");

    // get은 blocking call이므로 여기서 결과를 받을 때 대기하게 된다.
    System.out.println(submit.get());

    service.shutdown();
  }

  /**
   * Callable
   * 별도의 Thread가 작업한 return값을 받고 싶을 때 사용한다.
   */
  static class Task implements Callable<String> {

    @Override
    public String call() throws Exception {
      Thread.sleep(2000L);
      return Thread.currentThread() + " world";
    }
  }

}
