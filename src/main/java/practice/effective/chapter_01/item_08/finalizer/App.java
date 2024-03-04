package practice.effective.chapter_01.item_08.finalizer;

import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Field;

/**
 * 객체를 만드느라 너무 바빠서 Finalizer의 Queue에 들어있는 참조를 제거하지 못한다.
 * Queue를 처리하는 Thread의 우선순위가 더 낮기 때문이다.
 * Finalizer를 잘못 쓰면, 자기 자신 또는 다른 객체를 참조하면
 * 제거되지 못하기 때문에 객체가 계속 늘어난다.
 */
public class App {
  public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
    int i = 0;
    while (true) {
      i++;
      new FinalizerIsBad();

      if ((i % 1_000_000) == 0) {
        Class<?> finalizerClass = Class.forName("java.lang.ref.Finalizer");
        Field queueStaticField = finalizerClass.getDeclaredField("queue");
        queueStaticField.setAccessible(true);
        ReferenceQueue<Object> referenceQueue = (ReferenceQueue) queueStaticField.get(null);

        Field queueLengthField = ReferenceQueue.class.getDeclaredField("queueLength");
        queueLengthField.setAccessible(true);
        long queueLength = (long) queueLengthField.get(referenceQueue);
        System.out.format("There are %d references in the queue", queueLength);
      }
    }
  }
}
