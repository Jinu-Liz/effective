package practice.effective.chapter_01.item_03.staticfactory;

public class Main {
  public static void main(String[] args) {
    Elvis elvis = Elvis.getInstance();
    elvis.leaveTheBuilding();

    System.out.println(Elvis.getInstance());
    System.out.println(Elvis.getInstance());

    /**
     * 인스턴스는 동일하나, 원하는 타입으로 형변환을 해줄 수 있다.
     */
    MetaElvis<String> elvis1 = MetaElvis.getInstance();
    MetaElvis<Integer> elvis2 = MetaElvis.getInstance();

    System.out.println(elvis1.equals(elvis2));
//    System.out.println(elvis1 == elvis2);   // 타입이 다르기 때문에 == 비교가 되지 않는다.


    /**
     * Supplier를 통해 생성자를 만들어 사용할 수 있다.
     * (메서드 참조를 공급자로 사용할 수 있다.)
     */
    Concert concert = new Concert();
    concert.start(Elvis::getInstance);
  }
}
