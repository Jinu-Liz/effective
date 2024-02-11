package practice.effective.chapter_01.item_01.perfect.flyweight._01_before;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Character {

  private char value;

  private String color;

  private String fontFamily;

  private int fontSize;

}
