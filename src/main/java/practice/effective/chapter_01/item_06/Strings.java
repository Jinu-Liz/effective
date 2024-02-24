package practice.effective.chapter_01.item_06;

public class Strings {
  public static void main(String[] args) {
    String string1 = "string";
    String string2 = new String("string");    // String을 새롭게 생성해서 사용하지 않아야 한다.
    String string3 = "string";

    System.out.println(string1 == string2);
    System.out.println(string1.equals(string2));
    System.out.println(string1 == string3);
    System.out.println(string1.equals(string3));
  }
}
