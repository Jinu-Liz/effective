package practice.effective.chapter_08.item56;

import practice.effective.chapter_06.item39.repeatable_annotation.ExceptionTestContainer;

/**
 * 조회와 변경 메서드는 반드시 분리하자.
 * 조회 시 상태변경 등을 일으키는 경우, 사이드이펙트가 발생할 수 있다.
 */
public class DocExamples<E> {

  /**
   * 인자를 얻는 메서드
   * 클라이언트가 해당 메서드를 호출할 때, 어떤 조건을 만족해야 하는지
   * 무슨 일을 하는지 등등에 대해 적어둔다.
   *
   * @param index 매개변수에 대한 설명
   * @return 리턴 타입에 대한 설명
   * @throws IndexOutOfBoundsException 예외에 대한 설명
   */
  E get(int index) { return null; }

  /**
   * 자바독에 색인 추가 {@index IEE 754}
   */
  public void fragments() {
  }

  /**
   * 자기 사용 패턴 등 내부 구현 방식을 명확히 드러내기 위해 @implSpec 사용
   *
   * @implSpec This implementation return {@code this.size() == 0}.
   *
   * @return true if this collection is empty
   */
  public boolean isEmpty() { return false; }

  /**
   * escaping하기 위한 메서드
   * 머스타드 대령이나 {@literal Mrs. 피콕} 같은 용의자.
   */
  public void suspect() {}

  /**
   * 링크 걸기
   * {@link ExceptionTestContainer#value()}
   */
  public void link() {}
}
