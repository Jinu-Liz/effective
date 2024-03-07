package practice.effective.chapter_02.item_14.decimal;

public class IntOverflow {

  public static void main(String[] args) {
    System.out.println(-2147483648 - 10);   // 양수가 나와 버린다.
    System.out.println(Integer.compare(-2147483648, 10));   // Integer의 compare를 사용하여 비교.
  }
}
