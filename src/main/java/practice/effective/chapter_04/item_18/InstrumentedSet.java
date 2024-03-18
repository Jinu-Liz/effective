package practice.effective.chapter_04.item_18;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 상속 대신 컴포지션 사용.
 *
 * ForwardingSet이 Set 인터페이스를 그대로 구현하고 있기 때문에
 * 내부 구현에 상관없이 오버라이딩한 코드 그대로 동작한다.
 * 즉, 캡슐화가 잘 지켜진다.
 *
 * 또한 다른 구현체에 구애받지 않으며, Set에 변화가 일어나면 바로 알아차릴 수 있다.
 */
public class InstrumentedSet<E> extends ForwardingSet<E> {

  private int addCount = 0;

  public InstrumentedSet(Set<E> s) {
    super(s);
  }

  @Override
  public boolean add(E e) {
    addCount++;
    return super.add(e);
  }

  @Override
  public boolean addAll(Collection<? extends E> c) {
    addCount += c.size();
    return super.addAll(c);
  }

  public int getAddCount() {
    return addCount;
  }

  public static void main(String[] args) {
    InstrumentedSet<String> s = new InstrumentedSet<>(new HashSet<>());
    s.addAll(List.of("틱", "탁탁", "펑"));
    System.out.println(s.getAddCount());
  }
}
