package practice.effective.chapter_02.item_13;

public class DeepCopyHashTable implements Cloneable {

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

    /**
     * iterator를 사용한 깊은 복사
     */
    public Entry deepCopy2() {
      Entry result = new Entry(key, value, next);
      for (Entry p = result; p.next != null; p = p.next) {
        p.next = new Entry(p.next.key, p.next.value, p.next.next);
      }

      return result;
    }
  }

  /**
   * 깊은 복사.
   * 원본과 복사체 및 구성하는 모든 타입의 참조값이 다르다.
   *
   * deepCopy 메서드가 재귀호출을 하고 있으므로
   * stack overflow에 주의하여야 한다.
   */
  @Override
  protected DeepCopyHashTable clone() {
    DeepCopyHashTable result = null;
    try {
      result = (DeepCopyHashTable) super.clone();
      result.buckets = new Entry[this.buckets.length];    // 새 배열을 직접 만들어준다.
      for (int i = 0; i < this.buckets.length; i++) {
        if (buckets[i] != null) result.buckets[i] = this.buckets[i].deepCopy();
      }

      return result;
    } catch (CloneNotSupportedException e) {
      throw new AssertionError();
    }
  }

  public static void main(String[] args) {
    DeepCopyHashTable shallowCopyHashTable = new DeepCopyHashTable();
    Entry entry = new Entry(new Object(), new Object(), null);
    shallowCopyHashTable.buckets[0] = entry;
    DeepCopyHashTable clone = shallowCopyHashTable.clone();
    System.out.println(shallowCopyHashTable.buckets[0] == entry);
    System.out.println(shallowCopyHashTable.buckets[0] == clone.buckets[0]);
  }
}
