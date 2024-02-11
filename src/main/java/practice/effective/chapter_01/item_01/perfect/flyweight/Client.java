package practice.effective.chapter_01.item_01.perfect.flyweight;

import practice.effective.chapter_01.item_01.perfect.flyweight._02_after.Character;
import practice.effective.chapter_01.item_01.perfect.flyweight._02_after.FontFactory;

public class Client {
  public static void main(String[] args) {
    /**
     * 자주 사용하는 객체를 캐싱하여 사용한다.
     * 그만큼 객체를 가볍게 만들고, 메모리 사용량을 줄일 수 있다.
     */
    FontFactory factory = new FontFactory();
    Character c1 = new Character('h', "white", factory.getFont("nanum:12"));
    Character c2 = new Character('e', "white", factory.getFont("nanum:12"));
    Character c3 = new Character('l', "white", factory.getFont("nanum:12"));
  }
}
