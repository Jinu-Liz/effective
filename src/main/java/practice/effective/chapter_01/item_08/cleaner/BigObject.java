package practice.effective.chapter_01.item_08.cleaner;

import java.util.List;

public class BigObject {

  private List<Object> resource;

  public BigObject(List<Object> resource) { this.resource = resource; }

  /**
   * finalize에서 하던 일을, Runnable을 통하여 cleaner를 만들어 수행.
   * 다만, 반드시 static으로 만들어야하며, BigObject를 참조해서는 안된다.
   * cleaner를 통해 객체를 소멸시키는데, 객체를 참조하고 있으면 부활하기 때문.
   */
  public static class ResourceCleaner implements Runnable {

    private List<Object> resourceToClean;

    public ResourceCleaner(List<Object> resourceToClean) {
      this.resourceToClean = resourceToClean;
    }

    @Override
    public void run() {
      resourceToClean = null;
      System.out.println("cleaned up.");
    }
  }

}
