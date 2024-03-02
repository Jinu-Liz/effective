package practice.effective.chapter_01.item_07.reference;

import java.lang.ref.SoftReference;

public class SoftReferenceExample {
  public static void main(String[] args) throws InterruptedException {
    /**
     * Strong Reference를 참조. 따라서 해당 객체를 2군데서 참조한다.
     * 그러다가 Strong Reference의 참조가 해제되어 참조하는 곳이 1군데가 될 경우,
     * GC의 대상이 된다. 다만, 메모리가 부족할 경우에 제거한다.
     */
    Object strong = new Object();
    SoftReference<Object> soft = new SoftReference<>(strong);
    strong = null;

    System.gc();
    Thread.sleep(3000L);

    /**
     * 거의 없어지지 않는다.
     * 왜냐하면 메모리가 충분하기 때문에 굳이 제거할 필요가 없어서.
     */
    System.out.println(soft.get());
  }
}
