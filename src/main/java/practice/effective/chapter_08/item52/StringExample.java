package practice.effective.chapter_08.item52;

public class StringExample {
  public static void main(String[] args) {
    String name = "jinuliz";
    name.contentEquals(name);   // CharSequence를 매개변수로 받음

    // StringBuffer을 받지만, 내부에서는 CharSequence를 받는 메서드를 사용. 따라서 결과가 같다
    name.contentEquals(new StringBuffer(name));

    char[] data = {'e', 'd', 'd'};
    // 둘이 다른 일을 하는데 같은 메서드명을 사용함.
    System.out.println(String.valueOf((Object) data));  // String으로 바꿔줌
    System.out.println(String.valueOf(data)); // 문자열을 만들어 줌
  }
}
