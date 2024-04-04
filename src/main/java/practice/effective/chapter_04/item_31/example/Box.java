package practice.effective.chapter_04.item_31.example;

import lombok.ToString;

@ToString
public class Box<T extends Comparable<T>> implements Comparable<Box<T>> {

  protected T value;

  public Box(T value) {
    this.value = value;
  }

  public void change(T value) {
    this.value = value;
  }

  @SuppressWarnings("unchecked")
  @Override
  public int compareTo(Box anotherBox) {
    return this.value.compareTo((T) anotherBox.value);
  }
}
