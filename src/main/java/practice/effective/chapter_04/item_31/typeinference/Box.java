package practice.effective.chapter_04.item_31.typeinference;

public class Box<U> {

  private U value;

  public void set(U u) {
    this.value = u;
  }

  public U get() {
    return this.value;
  }
}
