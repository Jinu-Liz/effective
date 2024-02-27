package practice.effective.chapter_01.item_06.perfect;

public class Deprecation {

  /**
   * @deprecated in favor of
   * {@link #Deprecation(String)}
   * 변경/삭제 예정인 코드의 경우, deprecated를 통해
   * 추후의 가능성을 클라이언트에게 알려주어야 한다.
   * 프로퍼티를 통해 삭제 예정을 명시적으로 알려줄 수 있다.
   * 또한 link를 통해 대체 기능을 안내해줄 수 있다.
   *
   * javadoc을 생성할 경우, 명확하게 표시해준다.
   */
  @Deprecated(forRemoval = true, since = "1.3")
  public Deprecation() {}

  private String name;

  public Deprecation(String name) {
    this.name = name;
  }
}
