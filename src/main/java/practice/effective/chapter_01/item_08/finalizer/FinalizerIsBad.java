package practice.effective.chapter_01.item_08.finalizer;

public class FinalizerIsBad {

  @Override
  protected void finalize() throws Throwable {
    System.out.println("");
  }
}
