package practice.effective.chapter_08.item54;

import java.util.ArrayList;
import java.util.List;

public class CheeseStore {

  private final List<Cheese> cheesesInStock = new ArrayList<>();

  public CheeseStore(Cheese... cheeses) {
    for (Cheese cheese : cheeses) {
      this.addCheese(cheese);
    }
  }

  private void addCheese(Cheese cheese) {
    this.cheesesInStock.add(cheese);
  }

  // null을 리턴. 이런 경우, 사용하는 쪽에서 반드시 null체크를 해야한다.
  public List<Cheese> getCheese() {
    return this.cheesesInStock.isEmpty() ? null : new ArrayList<>(this.cheesesInStock);
  }

  // 빈 컬렉션을 반환하는게 null체크 부담을 덜어준다. 할당하지 않고 반환하면 성능적 비용을 줄일 수 있다.
  public List<Cheese> getCheese2() {
    return new ArrayList<>(this.cheesesInStock);
  }
}
