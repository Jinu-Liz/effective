package practice.effective.chapter_01.item_07.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class BigObjectReference<T> extends PhantomReference {
  public BigObjectReference(BigObject referent, ReferenceQueue<? extends BigObject> q) {
    super(referent, q);
  }

  public void cleanUp() {
    System.out.println("clean up");
  }
}
