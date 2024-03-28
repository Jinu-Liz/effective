package practice.effective.chapter_04.item_25;

/**
 * 두 클래스가 한 파일에 정의되는 경우, 컴파일을 어떻게하느냐에 따라
 * 결과가 달라지고, 때에 따라 에러가 발생할 수 있다. (Utensil.java와 중복)
 */
class Utensil {
  static final String NAME = "pot";
}

class Dessert {
  static final String NAME = "pie";
}
