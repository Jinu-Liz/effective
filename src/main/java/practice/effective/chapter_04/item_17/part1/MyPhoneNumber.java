package practice.effective.chapter_04.item_17.part1;

/**
 * PhoneNumber 객체에서 변경을 막아놓았지만,
 * 상속을 하면서 해당 값들을 바꿀 수 있게 되어버린다.
 * 불변 클래스가 가변 클래스가 되어버림.
 */
public class MyPhoneNumber extends PhoneNumber {

  public MyPhoneNumber(short areaCode, short prefix, short lineNum) {
    super(areaCode, prefix, lineNum);
  }

  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
