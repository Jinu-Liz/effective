package practice.effective.chapter_04.item_32.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Random;

public class ThreadLocalExampleAfter implements Runnable {

  private static final ThreadLocal<SimpleDateFormat> formatter = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMdd HHmm"));

  @Override
  public void run() {
    System.out.println("Thread Name = " + Thread.currentThread().getName() + " default Formatter = " + formatter.get().toPattern());
    try {
      Thread.sleep(new Random().nextInt(1000));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    this.formatter.set(new SimpleDateFormat());

    System.out.println("Thread Name = " + Thread.currentThread().getName() + " formatter = " + formatter.get().toPattern());
  }

  /**
   * 다른 Thread의 영향을 받지 않고, 자신 또한 다른 Thread에 영향을 주지 않는다.
   * ThreadLocal을 사용하면 해당 Thread의 공용 저장소 역할을 할 수 있기 때문에
   * 변수를 파라미터로 전달하지 않아도 된다. (Spring에서 사용)
   */
  public static void main(String[] args) throws InterruptedException {
    ThreadLocalExampleAfter obj = new ThreadLocalExampleAfter();
    for (int i = 0; i < 10; i++) {
      Thread t = new Thread(obj, "" + i);
      Thread.sleep(new Random().nextInt(1000));
      t.start();
    }
  }
}
