package practice.effective.chapter_01.item_01.perfect.flyweight.after;

import java.util.HashMap;
import java.util.Map;

/**
 * Font의 경우, 자주 변경되지 않기 때문에
 * 캐싱하여 사용하면 효율적이다.
 */
public class FontFactory {

  private Map<String, Font> cache = new HashMap<>();

  public Font getFont(String font) {
    if (cache.containsKey(font)) {

      return cache.get(font);
    } else {
      String[] split = font.split(":");
      Font newFont = new Font(split[0], Integer.parseInt(split[1]));
      cache.put(font, newFont);

      return newFont;
    }
  }

}
