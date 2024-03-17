package practice.effective.chapter_04.item_17.memorymodel;

public class MemoryModel {

  private final int x;

  private final int y;

  public MemoryModel() {
    this.x = 1;
    this.y = 2;
  }

  public static void main(String[] args) {
    /**
     * MemoryModel을 여러 쓰레드에서 공유해서 사용하는 경우,
     * 다른 쓰레드에서 값이 초기화가 되지 전에 참조하는 일이 발생할 수 있다.
     * 따라서, 아래와 같은 경우 x에 10이, y에 20이 할당되기 전에 참조하여
     * 0으로 참조하는 경우가 발생할 수도 있다. (이론적으로)
     *
     * final을 사용하면, 값이 할당될 때까지 freeze가 된다.
     * 따라서 값 할당이 보장이 된다.
     * 그러므로 반드시 초기화가 필요한 경우, 필드에 final을 사용하고 직접 값을 할당하는 것이 좋다.
     */
//    Object m = new MemoryModel();
//    model = m;
//    m.x = 10;
//    m.y = 20;

    MemoryModel model = new MemoryModel();
  }
}
