package practice.effective.chapter_01.item_07.reference;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

/**
 * Phantom reference를 사용하면, 메모리가 언제 해제되었는가를 알 수 있다.
 * 메모리에서 해제될 때, Queue에 들어간다.
 * 메모리에 민감한 어플리케이션의 경우, 또는 아주 큰 객체를 메모리에 올려야할 때 등
 * 메모리의 해제 시점을 알아야할 때 사용할 수 있다.
 */
public class PhantomReferenceExample {
  public static void main(String[] args) throws InterruptedException {
    BigObject strong = new BigObject();
    ReferenceQueue<BigObject> rq = new ReferenceQueue<>();

    BigObjectReference<BigObject> phantom = new BigObjectReference<>(strong, rq);
//    PhantomReference<BigObject> phantom = new PhantomReference<>(strong, rq);
    strong = null;

    System.gc();
    Thread.sleep(3000L);

    /**
     * 제거되었지만 사라지진않고 Queue에 들어간다.
     * 따라서 제거하고 싶으면 커스텀하여 제거
     */
    System.out.println(phantom.isEnqueued());
    Reference<? extends BigObject> reference = rq.poll();
    BigObjectReference bigObjectReference = (BigObjectReference) reference;
    bigObjectReference.cleanUp();
    reference.clear();
  }
}
