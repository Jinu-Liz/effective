package practice.effective.chapter_04.item_17.part1;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PhoneNumber {

  private short areaCode, prefix, lineNum;

}
