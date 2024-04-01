package practice.effective.chapter_04.item_29.object;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;

/**
 * Object를 사용한 Stack.
 * 최상위 객체인 Object를 사용했으므로 형변환을 해줘야한다.
 */
public class Stack {

  private Object[] elements;

  private int size = 0;

  private static final int DEFAULT_INITIAL_CAPACITY = 16;

  public Stack() {
    this.elements = new Object[ DEFAULT_INITIAL_CAPACITY ];
  }

  public void push(Object e) {
    ensureCapacity();
    this.elements[this.size++] = e;
  }

  public Object pop() {
    if (this.size == 0) throw new EmptyStackException();

    Object result = this.elements[--this.size];
    this.elements[this.size] = null; // 다 쓴 참조 해제

    return result;
  }

  private boolean isEmpty() {
    return this.size == 0;
  }

  private void ensureCapacity() {
    if (this.elements.length == size)
      this.elements = Arrays.copyOf(this.elements, 2 * this.size + 1);
  }

  public static void main(String[] args) {
    Stack stack = new Stack();
    for (String arg : List.of("a", "b", "c")) {
      stack.push(arg);
    }

    while (!stack.isEmpty())
      System.out.println(((String) stack.pop()).toUpperCase());
  }
}
