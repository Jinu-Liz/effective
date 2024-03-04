package practice.effective.chapter_01.item_08.cleaner;

import java.lang.ref.Cleaner;
import java.util.ArrayList;
import java.util.List;

public class CleanerIsNotGood {
  public static void main(String[] args) throws InterruptedException {
    /**
     * Phantom reference와 비슷하게 만들어졌다.
     */
    Cleaner cleaner = Cleaner.create();

    List<Object> resourceToCleanUp = new ArrayList<>();
    BigObject bigObject = new BigObject(resourceToCleanUp);
    cleaner.register(bigObject, new BigObject.ResourceCleaner(resourceToCleanUp));

    bigObject = null;
    System.gc();
    Thread.sleep(3000L);
  }
}
