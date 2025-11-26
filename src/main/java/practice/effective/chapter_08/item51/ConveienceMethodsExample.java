package practice.effective.chapter_08.item51;

import java.util.List;

// 메서드의 많고 적음은 주관적인 것이므로, 지나치게 많이 만들지만 않으면 될 듯.
public class ConveienceMethodsExample {

  // 편의 메서드가 너무 많은 클래스
  public class TooManyConvenienceMethods {
    private List<String> elements;

    public TooManyConvenienceMethods(List<String> elements) {
      this.elements = elements;
    }

    public void addElement(String element) {
      elements.add(element);
    }

    public void removeElement(String element) {
      elements.remove(element);
    }

    public boolean containsElement(String element) {
      return elements.contains(element);
    }

    public int getElementCount() {
      return elements.size();
    }

    public String getElementAt(int index) {
      return elements.get(index);
    }
  }

  // 적절한 메서드만 포함한 클래스
  public class AppropriateMethods {
    private List<String> elements;

    public AppropriateMethods(List<String> elements) {
      this.elements = elements;
    }

    public void addElement(String element) {
      elements.add(element);
    }

    public void removeElement(String element) {
      elements.remove(element);
    }

    public boolean containsElement(String element) {
      return elements.contains(element);
    }
  }
}
