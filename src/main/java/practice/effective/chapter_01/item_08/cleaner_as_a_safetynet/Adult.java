package practice.effective.chapter_01.item_08.cleaner_as_a_safetynet;

/**
 * cleaner 안전망을 갖춘 자원을 제대로 활용하는 클라이언트 (45쪽)
 * autocloseable을 사용하여 자원 반납. (close 메서드)
  */
public class Adult {
  public static void main(String[] args) {
    try (Room myRoom = new Room(7)) {
      System.out.println("안녕~");
    }
  }
}
