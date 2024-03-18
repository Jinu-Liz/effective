package practice.effective.chapter_04.item_17.concurrent;

import java.util.concurrent.CountDownLatch;

public class ConcurrentExample {

  public static void main(String[] args) throws InterruptedException {
    int N = 10;

    /**
     * CountDownLatch는 0이 되면 끝이나며 재사용할 수 없게 된다.
     */
    CountDownLatch startSignal = new CountDownLatch(1);
    CountDownLatch doneSignal = new CountDownLatch(N);

    for (int i = 0; i < N; i++) {
      new Thread(new Worker(startSignal, doneSignal)).start();
    }

    ready();
    startSignal.countDown();
    doneSignal.await();
    done();
  }

  private static void ready() {
    System.out.println("준비~~~");
  }

  private static void done() {
    System.out.println("끝!");
  }

  private static class Worker implements Runnable {

    private final CountDownLatch startSignal;

    private final CountDownLatch doneSignal;

    public Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
      this.startSignal = startSignal;
      this.doneSignal = doneSignal;
    }

    @Override
    public void run() {
      try {
        startSignal.await();
        doWork();
        doneSignal.countDown();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }

    void doWork() {
      System.out.println("working thread: " + Thread.currentThread().getName());
    }
  }
}
