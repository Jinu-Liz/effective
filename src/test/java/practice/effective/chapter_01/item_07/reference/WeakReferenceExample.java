package practice.effective.chapter_01.item_07.reference;

import java.lang.ref.WeakReference;

public class WeakReferenceExample {
  public static void main(String[] args) throws InterruptedException {
    /**
     * Strong Reference를 참조. 따라서 해당 객체를 2군데서 참조한다.
     * 그러다가 Strong Reference의 참조가 해제되어 참조하는 곳이 1군데가 될 경우, GC의 대상이 된다.
     * Soft Reference와 다르게 바로 제거된다.
     */
    Object strong = new Object();
    WeakReference<Object> weak = new WeakReference<>(strong);
    strong = null;

    System.gc();
    Thread.sleep(3000L);

    /**
     * 약하기 때문에 거의 없어진다.
     */
    System.out.println(weak.get());
  }
}
