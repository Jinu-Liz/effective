package practice.effective.chapter_04.item_20.templatemethod;

public class Client {
  public static void main(String[] args) {
    FileProcessor fileProcessor = new Plus("number.txt");
    System.out.println(fileProcessor.process());

    FileProcessorCallback fileProcessorCallback = new FileProcessorCallback("number.txt");
    System.out.println(fileProcessorCallback.process(Integer::sum));
  }
}
