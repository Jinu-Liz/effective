package practice.effective.chapter_04.item_31;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EmptyStackException;

/**
 * 와일드카드 타입을 이용해 대량 작업을 수행하는 메서드를 포함한 제네릭 스택
 */
public class StackAfter<E> {

  private E[] elements;

  private int size = 0;

  private static final int DEFAULT_INITIAL_CAPACITY = 16;

  @SuppressWarnings("unchecked")
  public StackAfter() {
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
   * 한정적 와일드카드를 사용
   * E 생산자(producer) 매개변수에 와일드카드 타입 적용
   * 하위 타입으로 변환해서 사용해도 안전하기 때문에 extends 사용
   */
  public void pushAll(Iterable<? extends E> src) {
    for (E e : src) {
      push(e);
    }
  }

  /**
   * E 소비자(consumer) 매개변수에 와일드카드 타입 적용
   * 상위 타입으로 변환해서 사용해도 안전하기 때문에 super 사용
   */
  public void popAll(Collection<? super E> dst) {
    while (!isEmpty()) {
      dst.add(pop());
    }
  }

  public static void main(String[] args) {
    StackAfter<Number> numberStack = new StackAfter<>();
    Iterable<Integer> integers = Arrays.asList(3, 1, 4, 1, 5, 9);
    numberStack.pushAll(integers);    // 한정적 와일드카드 사용으로 인해 Integer 타입도 가능해진다.

    Iterable<Double> doubles = Arrays.asList(3.1, 1.0, 4.0, 1.3, 5.4, 9.5);
    numberStack.pushAll(doubles);    // 한정적 와일드카드 사용으로 인해 Double 타입도 가능해진다.

    Collection<Object> objects = new ArrayList<>();
    numberStack.popAll(objects);    // 한정적 와일드카드 사용으로 상위 타입에 넣는 것이 가능
  }
}
