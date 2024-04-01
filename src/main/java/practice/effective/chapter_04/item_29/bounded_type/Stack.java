package practice.effective.chapter_04.item_29.bounded_type;

import java.io.Serializable;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;

/**
 * 2개를 함께 가진 타입으로 한정할 수도 있다.
 * (Number 안에 Serializable이 있기 때문에 아래는 무의미)
 */
public class Stack<E extends Number & Serializable> {

  /**
   * 기존에 컴파일을 하면 Object였으나,
   * 한정적 타입을 사용하면 해당 타입으로 바뀐다.
   * (위는 Number로 한정하여 Number 타입으로 바뀜)
   *
   * 기존 제네릭 타입에서 한정적 타입으로 변경하면 에러가 발생하는데,
   * Object 타입을 Number 타입으로 캐스팅하는 것은 안전하지 않기 때문이다.
   * (Number -> Object는 상관없다.)
   */
  private Number[] elements;

  private int size = 0;

  private static final int DEFAULT_INITIAL_CAPACITY = 16;

  @SuppressWarnings("unchecked")
  public Stack() {
    this.elements = new Number[ DEFAULT_INITIAL_CAPACITY ];
  }

  /**
   * Number로 타입이 한정되었기 때문에,
   * Number가 가지고 있는 모든 메서드를 사용할 수 있다.
   */
  public void push(E e) {
    ensureCapacity();
    this.elements[this.size++] = e;
  }

  public E pop() {
    if (this.size == 0) throw new EmptyStackException();

    @SuppressWarnings("unchecked")
    E result = (E)this.elements[--this.size];
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
    Stack<Integer> stack = new Stack<>();
    for (Integer arg : List.of(1, 2, 3)) {
      stack.push(arg);
    }

    while (!stack.isEmpty())
      System.out.println((stack.pop()));
  }
}
