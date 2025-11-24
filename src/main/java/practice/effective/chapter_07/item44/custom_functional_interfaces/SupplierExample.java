package practice.effective.chapter_07.item44.custom_functional_interfaces;

import java.util.Random;
import java.util.function.Supplier;

// 인자 없이 리턴만 있는 경우
public class SupplierExample {
  public static void main(String[] args) {
    Supplier<Integer> randomIntSupplier = () -> new Random().nextInt(100);
    Integer randomNumber = randomIntSupplier.get();

    System.out.println(randomNumber);
  }
}
