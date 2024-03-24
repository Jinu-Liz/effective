package practice.effective.chapter_04.item_21;

public interface MarketInterface {

  default void hello() {
    System.out.println("hello interface");
  }

}
