package practice.effective.chapter_01.item_04;

public class Main {
  public static void main(String[] args) {
    String hello = CommonUtils.hello();

    /**
     * 유틸리티성 클래스의 경우, 인스턴스를 생성할 필요가 없다.
     * 그럼에도 불구하고 생성하여 사용하는 경우, IDE에서 메서드 이름을 자동 완성 하지 않는다. (IntelliJ)
     */
//    CommonUtils commonUtils = new CommonUtils();
//    commonUtils.hello();
  }
}
