package practice.effective.chapter_01.item_08.cleaner_as_a_safetynet;

/**
 * cleaner 안전망을 갖춘 자원을 제대로 활용하지 못하는 클라이언트 (45쪽)
 * Room에 안전망으로 만들어놓은 Cleaner를 사용해서 자원반납을 하고 있다.
  */
public class Teenager {
  public static void main(String[] args) {
    new Room(99);
    System.out.println("Peace out");

    System.gc();
  }
}
