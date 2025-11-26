package practice.effective.chapter_08.item51;

import java.util.List;

public class NamingConventionsExample {

  // 명확한 메서드 이름: 리스트의 모든 요소를 출력
  public void printAllElements(List<String> elements) {
    for (String element : elements) {
      System.out.println(element);
    }
  }

  // 명확한 메서드 이름: 두 숫자의 합을 반환
  public int addNumbers(int a, int b) {
    return a + b;
  }

  // 명확한 메서드 이름: 주어진 문자열이 null 혹은 빈 문자열인지 확인
  public boolean isNullOrEmpty(String str) {
    return str == null || str.isEmpty();
  }
}
