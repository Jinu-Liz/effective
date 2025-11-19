package practice.effective.chapter_06.item39.marker_annotation;

public class Sample {

  @Test
  public static void testM1() {}  // 성공해야 함

  public static void testM2() {}

  @Test
  public static void testM3() { // 실패해야 함
    throw new RuntimeException("fail");
  }

  public static void m4() {}  // 테스트가 아님

  @Test
  public void testM5() {  // 잘못 사용한 예. 정적 메서드가 아니다.
  }

}
