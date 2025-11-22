package practice.effective.chapter_06.item41;

import practice.effective.chapter_06.item41.marker_annotation.MyAnnotation;

import java.io.Serializable;

/**
 * ObjectOutputStream.writeObject는 매개변수로 Object타입을 받지만,
 * 해당 Object가 Serializable 타입이 아닌 경우에 예외를 던진다.
 * 매개변수를 Serializable(마커 인터페이스)로 받았으면 더 좋았을 것.
 */
@MyAnnotation
public class Sample implements Serializable {

  public static void main(String[] args) {
    Sample sample = new Sample();
    if (sample instanceof MyAnnotation) {   // 어노테이션만으로는 타입을 구분할 수 없다.
      System.out.println("MyAnnotation");
    }
  }
}
