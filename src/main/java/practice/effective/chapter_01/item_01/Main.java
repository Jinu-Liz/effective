package practice.effective.chapter_01.item_01;

import practice.effective.chapter_01.item_01.after.AfterSettings;
import practice.effective.chapter_01.item_01.before.Settings;

public class Main {
  public static void main(String[] args) {
    // 매번 새로운 인스턴스가 생성됨.
    System.out.println(new Settings());
    System.out.println(new Settings());
    System.out.println(new Settings());


    /**
     * 생성자의 경우에 객체 생성을 제어할 수 없지만,
     * 정적 팩터리 메서드를 이용하면 같은 인스턴스를 사용하도록 제한할 수 있다.
     * (Singleton 패턴)
     */
    AfterSettings settings1 = AfterSettings.newInstance();
    AfterSettings settings2 = AfterSettings.newInstance();

    System.out.println(settings1);
    System.out.println(settings2);

    /**
     * TRUE / FALSE 객체를 미리 생성해놓고, 매개변수에 따라 가져다가 쓴다.
     * (Flyweight 패턴)
     */
    Boolean.valueOf(false);

    /**
     * 인터페이스를 타입으로 사용하여, 해당 기능(프레임워크)을 사용하도록 강제할 수 있다.
     * 또한 구체적인 타입(내용)을 숨길 수 있다.
     */
    HelloService ko = HelloServiceFactory.of("ko");
    HelloService eng = HelloService.of("eng");
  }
}
