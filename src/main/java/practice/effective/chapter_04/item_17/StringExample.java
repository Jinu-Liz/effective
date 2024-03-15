package practice.effective.chapter_04.item_17;

public class StringExample {
  public static void main(String[] args) {
    String name = "jinuliz";

    /**
     * String은 불변 객체이지만
     * 문자열을 가변으로 사용할 수 있는 클래스인 StringBuilder를 제공한다.
     * 즉, 가변인 동반 클래스를 제공하는 것으로 단점을 극복할 수 있다.
     */
    StringBuilder nameBuilder = new StringBuilder(name);
    nameBuilder.append("king");
  }
}
