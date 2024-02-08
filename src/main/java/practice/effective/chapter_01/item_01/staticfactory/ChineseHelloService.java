package practice.effective.chapter_01.item_01.staticfactory;

import practice.effective.chapter_01.item_01.staticfactory.good.HelloServiceEx;

public class ChineseHelloService implements HelloServiceEx {

  @Override
  public String hello() {
    return "Ni Hao";
  }
}
