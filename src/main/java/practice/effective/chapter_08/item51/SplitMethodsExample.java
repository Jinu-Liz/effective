package practice.effective.chapter_08.item51;

public class SplitMethodsExample {

  // 너무 많은 매개변수를 가진 메서드.
  public void processOrder(String customerName, String customerAddress, String productName, int quantity, double price, String paymentMethod) {
    // 주문 처리 로직
  }

  // 매개변수 목록을 짧게 유지하기 위하여 메서드를 쪼갠 예제
  public void processOrder(Order order) {
    validateOrder(order);
    processPayment(order);
    shipOrder(order);
  }

  private void validateOrder(Order order) {

  }

  private void processPayment(Order order) {

  }

  private void shipOrder(Order order) {

  }

  public class Order {

    private String customerName;

    private String customerAddress;

    private String productName;

    private int quantity;

    private double price;

    private String paymentMethod;

  }
}
