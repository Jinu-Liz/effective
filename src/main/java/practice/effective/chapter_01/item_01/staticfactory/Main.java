package practice.effective.chapter_01.item_01.staticfactory;

import practice.effective.chapter_01.item_01.staticfactory.ChineseHelloService;
import practice.effective.chapter_01.item_01.staticfactory.good.HelloService;
import practice.effective.chapter_01.item_01.staticfactory.good.HelloServiceEx;
import practice.effective.chapter_01.item_01.staticfactory.good.HelloServiceFactory;
import practice.effective.chapter_01.item_01.staticfactory.good.after.AfterSettings;
import practice.effective.chapter_01.item_01.staticfactory.good.before.Settings;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ServiceLoader;

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


    /**
     * HelloServiceEx의 구현체로 등록되어있는 클래스들을 모두 찾는다.
     * 인터페이스만 있어도 사용 가능하다. (정적 팩터리 메서드가 있는 상태에서, 구현체가 존재하지 않아도 된다.)
     *
     */
    ServiceLoader<HelloServiceEx> loader = ServiceLoader.load(HelloServiceEx.class);
    Optional<HelloServiceEx> helloServiceExOptional = loader.findFirst();
    helloServiceExOptional.ifPresent(h -> {
      System.out.println(h.hello());
    });

    /**
     * 위 코드는 ChineseHelloService에 의존적이지 않지만, 아래 코드는 의존적이다.
     * 따라서, 위의 코드는 구현체의 존재를 몰라도 되고 아래 코드는 구현체의 존재를 알아야 사용할 수 있는 코드이다.
     */
    HelloServiceEx helloServiceEx = new ChineseHelloService();
    System.out.println(helloServiceEx.hello());

    /**
     * List의 경우, 생성자를 통해 사용할 수도 있고
     * 정적 팩터리 메서드를 통해서 사용할 수도 있다.
     */
    List<String> list = new ArrayList<>();
    List.of("jinuliz", "stich");
  }
}
