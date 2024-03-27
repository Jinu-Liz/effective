package practice.effective.chapter_04.item_24.memberclass;

import java.util.AbstractSet;
import java.util.Iterator;

public class MySet<E> extends AbstractSet<E> {
  @Override
  public Iterator<E> iterator() {
    return new MyIterator();
  }

  @Override
  public int size() {
    return 0;
  }

  /**
   * 내부 클래스로 구현체를 만들어 사용
   */
  private class MyIterator implements Iterator<E> {

    @Override
    public boolean hasNext() {
      return false;
    }

    @Override
    public E next() {
      return null;
    }
  }
}
