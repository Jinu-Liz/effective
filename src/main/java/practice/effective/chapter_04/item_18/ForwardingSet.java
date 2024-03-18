package practice.effective.chapter_04.item_18;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * 재사용할 수 있는 전달 클래스.
 * Forwarding class, wrapper class, decorator pattern 등으로 볼 수 있다.
 */
public class ForwardingSet<E> implements Set<E> {

  private final Set<E> s;

  public ForwardingSet(Set<E> s) {
    this.s = s;
  }

  @Override
  public int size() {
    return this.s.size();
  }

  @Override
  public boolean isEmpty() {
    return this.s.isEmpty();
  }

  @Override
  public boolean contains(Object o) {
    return this.s.contains(o);
  }

  @Override
  public Iterator<E> iterator() {
    return this.s.iterator();
  }

  @Override
  public Object[] toArray() {
    return this.s.toArray();
  }

  @Override
  public <T> T[] toArray(T[] a) {
    return this.s.toArray(a);
  }

  @Override
  public boolean add(E e) {
    return this.s.add(e);
  }

  @Override
  public boolean remove(Object o) {
    return this.s.remove(o);
  }

  @Override
  public boolean containsAll(Collection<?> c) {
    return this.s.containsAll(c);
  }

  @Override
  public boolean addAll(Collection<? extends E> c) {
    return this.s.addAll(c);
  }

  @Override
  public boolean retainAll(Collection<?> c) {
    return this.s.retainAll(c);
  }

  @Override
  public boolean removeAll(Collection<?> c) {
    return this.s.removeAll(c);
  }

  @Override
  public void clear() {
    this.s.clear();
  }
}
