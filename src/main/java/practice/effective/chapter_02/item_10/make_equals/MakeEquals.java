package practice.effective.chapter_02.item_10.make_equals;

public class MakeEquals {

  private final int a;

  private final int b;

  public MakeEquals(int a, int b) {
    this.a = a;
    this.b = b;
  }

  @Override
  public boolean equals(Object obj) {

    // 반사성(동일) 확인
    if (this == obj) return true;

    // 타입 비교
    if (!(obj instanceof MakeEquals))
      return false;

    // 타입 캐스팅
    MakeEquals me = (MakeEquals) obj;

    // 필드값 비교 (핵심적인 필드)
    return me.a == this.a && me.b == this.b;
  }
}
