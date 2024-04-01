package practice.effective.chapter_04.item_29.technique1;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;

public class Stack<E> {

  private E[] elements;

  private int size = 0;

  private static final int DEFAULT_INITIAL_CAPACITY = 16;

  /**
   * 배열 elements는 push(E)로 넘어온 E 인스턴스만 담는다.
   * 따라서 타입 안전성을 보장하지만, 이 배열의 런타임 타입은 E[]가 아닌 Object[]다.
   *
   * 제네릭 배열 (E[])을 생성하지 못하기 때문에
   * Object를 생성 후, 제네릭 배열 타입으로 캐스팅해준다.
   *
   * Heap 오염이 일어날 가능성이 있다.
   */
  @SuppressWarnings("unchecked")
  public Stack() {
    this.elements = (E[]) new Object[ DEFAULT_INITIAL_CAPACITY ];
  }

  public void push(E e) {
    ensureCapacity();
    this.elements[this.size++] = e;
  }

  public E pop() {
    if (this.size == 0) throw new EmptyStackException();

    E result = this.elements[--this.size];
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
      System.out.println((stack.pop()).toUpperCase());
  }
}
