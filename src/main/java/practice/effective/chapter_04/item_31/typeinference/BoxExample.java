package practice.effective.chapter_04.item_31.typeinference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoxExample {

  private static <U> void addBox(U u, List<Box<U>> boxes) {
    Box<U> box = new Box<>();
    box.set(u);
    boxes.add(box);
  }

  private static <U> void outputBoxes(List<Box<U>> boxes) {
    int counter = 0;
    for (Box<U> box : boxes) {
      U boxContents = box.get();
      System.out.println("Box #" + counter + " contains [" + boxContents.toString() + "]");
      counter++;
    }
  }

  private static void processStringList(List<String> stringList) {

  }

  public static void main(String[] args) {
    ArrayList<Box<Integer>> listOfIntegerBoxes = new ArrayList<>();
    BoxExample.<Integer>addBox(10, listOfIntegerBoxes);   // 명시적 타입 인수 (type witness). 안써도 무방하다.
    BoxExample.addBox(20, listOfIntegerBoxes);
    BoxExample.addBox(30, listOfIntegerBoxes);
    BoxExample.outputBoxes(listOfIntegerBoxes);

    /**
     * Target Type.
     * emptyList()가 알아서 타입을 추론한다.
      */
    List<String> stringList = Collections.emptyList();
    List<Integer> integerList = Collections.emptyList();

    // 자동으로 String으로 추론한다.
    BoxExample.processStringList(Collections.emptyList());
  }
}
