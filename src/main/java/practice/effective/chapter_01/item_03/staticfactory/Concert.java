package practice.effective.chapter_01.item_03.staticfactory;

import java.util.function.Supplier;

public class Concert {

  public void start(Supplier<Singer> singerSupplier) {
    Singer singer = singerSupplier.get();
    singer.sing();
  }

}
