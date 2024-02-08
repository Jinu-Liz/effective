package practice.effective;

import practice.effective.chapter_01.item_01.HelloServiceEx;

public class ChineseHelloService implements HelloServiceEx {

  @Override
  public String hello() {
    return "Ni Hao";
  }
}
