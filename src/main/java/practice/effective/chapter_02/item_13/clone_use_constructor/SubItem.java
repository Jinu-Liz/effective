package practice.effective.chapter_02.item_13.clone_use_constructor;

public class SubItem extends Item implements Cloneable {

  private String name;

  @Override
  protected SubItem clone() {

    /**
     * clone 실패.
     * Item -> SubItem으로 변환하지 못하기 때문. (Item이 상위라서)
     */
    return (SubItem) super.clone();
  }

  public static void main(String[] args) {
    SubItem item = new SubItem();

    /**
     * Object의 clone에 따라 Item에 있는 clone이 호출된다.
     * 따라서 clone을 사용할 때, 생성자를 사용하면 안된다.
     */
    SubItem clone = (SubItem) item.clone();
    System.out.println(clone != null);
    System.out.println(clone.getClass() == item.getClass());
    System.out.println(clone.equals(item));
  }
}
