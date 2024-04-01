package practice.effective.chapter_04.item_29.technique2;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;

/**
 * Object[]를 사용한 제네릭 Stack.
 */
public class Stack<E> {

  private Object[] elements;

  private int size = 0;

  private static final int DEFAULT_INITIAL_CAPACITY = 16;

  public Stack() {
    this.elements = new Object[ DEFAULT_INITIAL_CAPACITY ];
  }

  public void push(E e) {
    ensureCapacity();
    this.elements[this.size++] = e;
  }

  public E pop() {
    if (this.size == 0) throw new EmptyStackException();

    /**
     * push에서 E 타입만 허용하므로 이 형변환은 안전하다.
     *
     * 꺼낼 때마다 형변환을 해줘야한다는 단점이 있다.
      */
    @SuppressWarnings("unchecked")
    E result = (E) this.elements[--this.size];
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
    Stack<String> stack = new Stack<>();
    for (String arg : List.of("a", "b", "c")) {
      stack.push(arg);
    }

    while (!stack.isEmpty())
      System.out.println(((String) stack.pop()).toUpperCase());
  }
}
