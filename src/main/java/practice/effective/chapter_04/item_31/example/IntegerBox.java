package practice.effective.chapter_04.item_31.example;

import lombok.ToString;

@ToString
public class IntegerBox extends Box<Integer> {

  private final String message;

  public IntegerBox(int value, String message) {
    super(value);
    this.message = message;
  }
}
