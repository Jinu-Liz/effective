package practice.effective.chapter_01.item_03.field;

import lombok.Getter;

public class Concert {

  @Getter
  private boolean lightsOn;

  @Getter
  private boolean mainStateOpen;

  private Elvis elvis;

  public Concert(Elvis elvis) {
    this.elvis = elvis;
  }

  public void perform() {
    mainStateOpen = true;
    lightsOn = true;
    elvis.sing();
  }

}
