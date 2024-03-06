package practice.effective.chapter_02.item_11.hashcode;

import com.google.common.hash.Funnel;
import com.google.common.hash.Hashing;
import com.google.common.hash.PrimitiveSink;

public class GuavaHashCode {

  private final int num;

  public GuavaHashCode(int num) {
    this.num = num;
  }

  // guava의 hashcode 만들기
  @Override
  public int hashCode() {
    return Hashing.goodFastHash(32)
      .hashObject(this, GuavaHashCodeFunnel.INSTANCE)
      .hashCode();
  }

  private static class GuavaHashCodeFunnel implements Funnel<GuavaHashCode> {

    private static final GuavaHashCodeFunnel INSTANCE = new GuavaHashCodeFunnel();

    @Override
    public void funnel(GuavaHashCode from, PrimitiveSink into) {
      into.putInt(from.hashCode()).putInt(from.num);
    }
  }
}
