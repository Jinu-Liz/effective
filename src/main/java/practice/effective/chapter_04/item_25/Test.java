package practice.effective.chapter_04.item_25;

/**
 * 어떤 클래스가 다른 클래스에 종속적이라면
 * 정적 멤버 클래스로 작성을 하는 것이 가독성도 좋고
 * private 접근 지시자를 사용하여 접근 범위를 최소화할 수 있다.
 */
public class Test {
  public static void main(String[] args) {
    System.out.println(Utensil.NAME + Dessert.NAME);
  }

  private static class Utensil {
    static final String NAME = "pan";
  }

  private static class Dessert {
    static final String NAME = "cake";
  }

}
