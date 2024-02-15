package practice.effective.chapter_01.item_03.field;

/**
 * 인터페이스를 사용하면, Elvis라는 '역할'을 부여함으로써
 * 대역이 가능하도록 만든다.
 * 따라서 진짜 Elvis의 대역을 사용하여 쉽게 테스트가 가능해진다.
 */
public interface IElvis {

  void leaveTheBuilding();

  void sing();

}
