package practice.effective.chapter_04.item_32.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Random;

public class ThreadLocalExampleBefore implements Runnable {

  private SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd HHmm");

  @Override
  public void run() {
    System.out.println("Thread Name = " + Thread.currentThread().getName() + " default Formatter = " + formatter.toPattern());
    try {
      Thread.sleep(new Random().nextInt(1000));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    this.formatter = new SimpleDateFormat();

    System.out.println("Thread Name = " + Thread.currentThread().getName() + " formatter = " + formatter.toPattern());
  }

  /**
   * 기본 포맷이 "yyyyMMdd HHmm" 형태이다가
   * 어느 순간부터 기본이 바뀐 포맷으로 변경된다.
   */
  public static void main(String[] args) throws InterruptedException {
    ThreadLocalExampleBefore obj = new ThreadLocalExampleBefore();
    for (int i = 0; i < 10; i++) {
      Thread t = new Thread(obj, "" + i);
      Thread.sleep(new Random().nextInt(1000));
      t.start();
    }
  }
}
