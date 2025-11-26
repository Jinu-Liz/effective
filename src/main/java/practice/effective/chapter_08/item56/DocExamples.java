package practice.effective.chapter_08.item56;

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

}
