package practice.effective.chapter_04.item_18;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * 상속을 잘못 사용한 예
 */
public class InstrumentedHashSet<E> extends HashSet<E> {

  private int addCount = 0;

  public InstrumentedHashSet() {
  }

  public InstrumentedHashSet(int initCap, float loadFactor) {
    super(initCap, loadFactor);
  }

  @Override
  public boolean add(E e) {
    this.addCount++;
    return super.add(e);
  }

  /**
   * 부모의 내부 구현이 노출된다.
   * 따라서, 호출하는 부모 메서드가 어떻게 동작하는지를 알아야
   * 해당 메서드를 정확하게 사용할 수 있다.
   *
   * 또한 추후에 부모에 addCount역할을 하는 메서드가 생기거나
   * 다른 메서드 내에 동일한 역할을 하는 기능이 추가된다면
   * 예상치 못한 결과를 얻을 수 있다.
   */
  @Override
  public boolean addAll(Collection<? extends E> c) {
    this.addCount += c.size();
    return super.addAll(c);
  }

  public int getAddCount() {
    return this.addCount;
  }

  public static void main(String[] args) {
    InstrumentedHashSet<String> s = new InstrumentedHashSet<>();
    s.addAll(List.of("틱", "탁탁", "펑"));
    System.out.println(s.getAddCount());
  }
}
