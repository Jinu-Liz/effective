package practice.effective.chapter_02.item_13;

import java.util.Arrays;
import java.util.EmptyStackException;

public class GoodStack implements Cloneable {

  private Object[] elements;

  private int size = 0;

  public static final int DEFAULT_INITIAL_CAPACITY = 16;

  public GoodStack() {
    this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
  }

  public void push(Object o) {
    ensureCapacity();
    this.elements[size++] = o;
  }

  public Object pop() {
    if (size == 0) throw new EmptyStackException();
    Object result = this.elements[--size];
    this.elements[size] = null;

    return result;
  }

  private void ensureCapacity() {
    if (this.elements.length == size) this.elements = Arrays.copyOf(elements, 2 * size + 1);
  }

  /**
   * elements도 clone해주어, 복사체를 참조하도록 한다.
   * 그러나 elements의 값들은 같은 reference를 참조.
   * shallow copy이기 때문이다.
   *
   * stack -> elementsA[0, 1]
   * copy -> elementsB[0, 1]
   * elementsA[0] == elementsB[0]
   *
   * 따라서 elements의 값을 변경이 생기면 원본-복사체 양쪽에 영향이 간다.
   */
  @Override
  public GoodStack clone() {
    try {
      GoodStack result = (GoodStack) super.clone();
      result.elements = elements.clone();

      return result;
    } catch (CloneNotSupportedException e) {
      throw new AssertionError();
    }
  }



  public static void main(String[] args) {
    Object[] values = new Object[2];
    values[0] = new PhoneNumber(123, 456, 7890);
    values[1] = new PhoneNumber(321, 764, 2341);

    GoodStack stack = new GoodStack();
    for (Object arg : values) {
      stack.push(arg);
    }

    GoodStack copy = stack.clone();

    System.out.println("pop from stack");
    while (!stack.isEmpty()) {
      System.out.println(stack.pop() + " ");
    }

    /**
     * 같은 element를 참조하기 때문에, null이다.
     * 앞에서 pop으로 전부 빼버렸기 때문.
     */
    System.out.println("pop from copy");
    while (!copy.isEmpty()) {
      System.out.println(copy.pop() + " ");
    }

    System.out.println(stack.elements[0] == copy.elements[0]);
  }

  private boolean isEmpty() {

    return size == 0;
  }
}
