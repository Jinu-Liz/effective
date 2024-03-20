package practice.effective.chapter_04.item_18.callback;

public class BobFunction implements FunctionToCall {

  private final Service service;

  public BobFunction(Service service) {
    this.service = service;
  }

  @Override
  public void call() {
    System.out.println("밥을 먹을까..");
  }

  /**
   * 이 this가 BobFunctionWrapper가 아니라
   * BobFunction이기 때문에 Wrapper를 쓰는 이유가 없어짐.
   * 때문에 기대한 바와 다른 결과를 얻게 된다.
   */
  @Override
  public void run() {
    this.service.run(this);
  }
}
