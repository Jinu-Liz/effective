package practice.effective.chapter_02.item_13;

public class ShallowCopyHashTable implements Cloneable {

  private Entry[] buckets = new Entry[10];

  private static class Entry {
    final Object key;
    Object value;
    Entry next;

    public Entry(Object key, Object value, Entry next) {
      this.key = key;
      this.value = value;
      this.next = next;
    }

    public void add(Object key, Object value) {
      this.next = new Entry(key, value, null);
    }

    public Entry deepCopy() {
      return new Entry(key, value, next == null ? null : next.deepCopy());
    }
  }

  /**
   * 얕은 복사.
   * Entry[] 까지는 복사하나, 그 속에 Entry까지는 복사하지 못한다.
   */
  @Override
  protected ShallowCopyHashTable clone() {
    ShallowCopyHashTable result = null;
    try {
      result = (ShallowCopyHashTable) super.clone();
      result.buckets = this.buckets.clone();

      return result;
    } catch (CloneNotSupportedException e) {
      throw new AssertionError();
    }
  }

  public static void main(String[] args) {
    ShallowCopyHashTable shallowCopyHashTable = new ShallowCopyHashTable();
    Entry entry = new Entry(new Object(), new Object(), null);
    shallowCopyHashTable.buckets[0] = entry;
    ShallowCopyHashTable clone = shallowCopyHashTable.clone();
    System.out.println(shallowCopyHashTable.buckets[0] == entry);
    System.out.println(shallowCopyHashTable.buckets[0] == clone.buckets[0]);
  }
}
