package practice.effective.chapter_04.item_26.raw;

public class UseRawType<E> {

  private E e;

  public static void main(String[] args) {

    System.out.println(UseRawType.class);

    UseRawType<String> stringType = new UseRawType<>();

    /**
     * UseRawType<String>으로 해도 소거되기 때문에
     * 타입을 선언해도 코드를 장황하게 할 뿐이므로 제거.
     */
    System.out.println(stringType instanceof UseRawType);
  }
}
