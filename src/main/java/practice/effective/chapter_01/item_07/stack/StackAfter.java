package practice.effective.chapter_01.item_07.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class StackAfter {

  private Object[] elements;

  private int size = 0;

  public static final int DEFAULT_INITIAL_CAPACITY = 16;

  public StackAfter() {
    this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
  }

  public void push(Object o) {
    ensureCapacity();
    this.elements[size++] = o;
  }

  /**
   * 꺼낼 때마다 해당 index의 객체를 해제함으로써
   * 메모리 누수를 방지할 수 있다.
   */
  public Object pop() {
    if (size == 0) throw new EmptyStackException();
    Object result = this.elements[--size];
    this.elements[size] = null;   // 다 쓴 참조 해제

    return result;
  }

  /**
   * 원소를 위한 공간을 적어도 하나 이상 확보한다.
   * 배열 크기를 늘려야 할 때마다 대략 두 배씩 늘린다.
   */
  private void ensureCapacity() {
    if (this.elements.length == size) this.elements = Arrays.copyOf(elements, 2 * size + 1);
  }

}
