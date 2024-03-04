package practice.effective.chapter_01.item_08.cleaner_as_a_safetynet;

import java.lang.ref.Cleaner;

// cleaner를 안전망으로 활용하는 AutoCloseable 클래스
public class Room implements AutoCloseable {

  public static final Cleaner cleaner = Cleaner.create();

  // 청소가 필요한 자원. Room을 참조해서는 안된다.
  private static class State implements Runnable {
    int numJunkPiles;  // Number of junk piles in this room

    State(int numJunkPiles) { this.numJunkPiles = numJunkPiles; }

    @Override
    public void run() {
      System.out.println("cleaning room");
      numJunkPiles = 0;
    }
  }

  // 방의 상태. cleanable과 공유한다.
  private final State state;

  // cleanable 객체. 수거 대상이 되면 방을 청소한다.
  private final Cleaner.Cleanable cleanable;

  public Room(int numJunkPiles) {
    this.state = new State(numJunkPiles);
    this.cleanable = cleaner.register(this, state);
  }

  @Override
  public void close() {
    System.out.println("autocloseable 사용");
    this.cleanable.clean();
  }
}
