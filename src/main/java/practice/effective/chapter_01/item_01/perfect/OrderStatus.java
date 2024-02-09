package practice.effective.chapter_01.item_01.perfect;

/**
 * DB에 저장된 값이 숫자일 경우,
 * 별도로 지정하여 사용할 수 있다.
 */
public enum OrderStatus {

  PREPARING(0),
  SHIPPED(1),
  DELIVERING(2),
  DELIVERED(3);

  private int number;

  OrderStatus(int number) {
    this.number = number;
  }

}
