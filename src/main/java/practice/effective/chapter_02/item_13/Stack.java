package practice.effective.chapter_02.item_13;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack implements Cloneable {

  private Object[] elements;

  private int size = 0;

  public static final int DEFAULT_INITIAL_CAPACITY = 16;

  public Stack() {
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
   * TODO Stack의 copy가 만들어졌을 때, 동일한 elements를 참조하게 된다.
   */
  @Override
  public Stack clone() {
    try {
      Stack result = (Stack) super.clone();

      return result;
    } catch (CloneNotSupportedException e) {
      throw new AssertionError();
    }
  }



  public static void main(String[] args) {
    Object[] values = new Object[2];
    values[0] = new PhoneNumber(123, 456, 7890);
    values[1] = new PhoneNumber(321, 764, 2341);

    Stack stack = new Stack();
    for (Object arg : values) {
      stack.push(arg);
    }

    Stack copy = stack.clone();

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
