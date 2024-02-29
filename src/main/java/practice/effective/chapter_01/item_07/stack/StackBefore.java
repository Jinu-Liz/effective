package practice.effective.chapter_01.item_07.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class StackBefore {

  private Object[] elements;

  private int size = 0;

  public static final int DEFAULT_INITIAL_CAPACITY = 16;

  public StackBefore() {
    this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
  }

  public void push(Object o) {
    ensureCapacity();
    this.elements[size++] = o;
  }

  /**
   * 계속 꺼내서 주기만 하면 elements 배열에서 사라지지 않는다.
   * 무언가를 참조하고 있을 경우, GC의 대상이 되지 않는다.
   * 따라서 언젠가는 메모리 누수가 발생하여 OOM이 발생할 것.
   */
  public Object pop() {
    if (size == 0) throw new EmptyStackException();

    return elements[--size];
  }

  /**
   * 원소를 위한 공간을 적어도 하나 이상 확보한다.
   * 배열 크기를 늘려야 할 때마다 대략 두 배씩 늘린다.
   */
  private void ensureCapacity() {
    if (this.elements.length == size) this.elements = Arrays.copyOf(elements, 2 * size + 1);
  }

}
