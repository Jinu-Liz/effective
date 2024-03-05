package practice.effective.chapter_02.item_10.make_equals.autovalue;

import com.google.auto.value.AutoValue;

@AutoValue
abstract class Point {
  static Point create(int x, int y) {

    /**
     * 찾질 못하지만 build하면 class파일이 존재한다.
     */
    return new AutoValue_Point(x, y);
  }

  abstract int x();

  abstract int y();
}
