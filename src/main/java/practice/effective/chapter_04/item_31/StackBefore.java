package practice.effective.chapter_04.item_31;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EmptyStackException;

/**
 * 와일드카드 타입을 이용해 대량 작업을 수행하는 메서드를 포함한 제네릭 스택
 */
public class StackBefore<E> {

  private E[] elements;

  private int size = 0;

  private static final int DEFAULT_INITIAL_CAPACITY = 16;

  @SuppressWarnings("unchecked")
  public StackBefore() {
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

  /**
   * 와일드카드 타입을 사용하지 않은 pushAll 메서드 - 결함이 있다.
   */
  public void pushAll(Iterable<E> src) {
    for (E e : src) {
      push(e);
    }
  }

  public void popAll(Collection<E> dst) {
    while (!isEmpty()) {
      dst.add(pop());
    }
  }

  public static void main(String[] args) {
//    StackBefore<Number> numberStack = new StackBefore<>();
//    Iterable<Integer> integers = Arrays.asList(3, 1, 4, 1, 5, 9);
//    numberStack.pushAll(integers);    // Number 타입이기 때문에 에러가 발생한다.
//
//    Collection<Object> objects = new ArrayList<>();
//    numberStack.popAll(objects);    // Number 타입이기 때문에 에러가 발생한다.
  }
}
