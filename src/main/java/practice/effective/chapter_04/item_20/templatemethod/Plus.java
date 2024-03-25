package practice.effective.chapter_04.item_20.templatemethod;

public class Plus extends FileProcessor {

  public Plus(String path) {
    super(path);
  }

  @Override
  protected int getResult(int result, int number) {
    return result + number;
  }
}