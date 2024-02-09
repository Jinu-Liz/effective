package practice.effective.chapter_01.item_01.perfect;

import java.util.Arrays;

public class Main {
  public static void main(String[] args) {

    Order order = new Order();

    // NPE 발생
    if (order.getOrderStatus().equals(OrderStatus.DELIVERED)) {
      System.out.println("delivered");
    }

    // 따라서 Enum을 비교할 경우에는 '=='로 비교하는 것이 좋다.
    if (order.getOrderStatus() == OrderStatus.DELIVERED) {
      System.out.println("delivered");
    }

    Arrays.stream(OrderStatus.values()).forEach(System.out::println);
  }
}
