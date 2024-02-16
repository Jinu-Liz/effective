package practice.effective.chapter_01.item_03.staticfactory;

public class MetaElvis<T> {

  public static final MetaElvis<Object> INSTANCE = new MetaElvis<>();

  private MetaElvis() {}

  /**
   * 정적 팩터리 메서드를 사용하면 제네릭 타입을 사용할 수 있다.
   *
   * 앞에 <T>는 Class의 <T>와 scope가 다르다.
   * 예로, T를 E로 바꿔도 문제 없음.
   */
  @SuppressWarnings("unchecked")
  public static <T> MetaElvis<T> getInstance() { return (MetaElvis<T>) INSTANCE; }

  /**
   * 여기에 들어가는 T는 Class의 <T>이다.
   */
  public void say(T t) {
    System.out.println(t);
  }

  public void leaveTheBuilding() {
    System.out.println("Whoa baby, I'm outta here!");
  }

}
