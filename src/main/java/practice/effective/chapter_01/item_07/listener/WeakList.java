package practice.effective.chapter_01.item_07.listener;

import java.lang.ref.WeakReference;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;

public class WeakList<T> extends AbstractList<T> {

  private ArrayList<T> items;

  public WeakList() {
    this.items = new ArrayList<>();
  }

  @Override
  public T get(int i) {
    return this.items.get(i);
  }

  @Override
  public int size() {
    removeReleased();
    return this.items.size();
  }

  @Override
  public boolean add(T o) {
    return this.items.add(o);
  }

  private void removeReleased() {
    for (Iterator<T> it = this.items.iterator(); it.hasNext();) {
      WeakReference ref = (WeakReference) it.next();
      if (ref.get() == null) this.items.remove(ref);
    }
  }
}
