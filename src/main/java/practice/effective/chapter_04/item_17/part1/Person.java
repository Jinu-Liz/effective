package practice.effective.chapter_04.item_17.part1;

public final class Person {

  private final Address address;

  public Person(Address address) {
    this.address = address;
  }

  /**
   * 가변적인 컴포넌트에 getter를 만들지 않거나
   * 정말 필요한 경우, 방어적인 복사를 통해 불변 객체를 유지할 수 있다.
   */
  public Address getAddress() {
    Address copyOfAddress = new Address();
    copyOfAddress.setCity(address.getCity());
    copyOfAddress.setZipcode(address.getZipcode());
    copyOfAddress.setStreet(address.getStreet());

    return copyOfAddress;
  }

  public static void main(String[] args) {
    Address seattle = new Address();
    seattle.setCity("Seattle");

    Person person = new Person(seattle);
    Address redmond = person.getAddress();
    redmond.setCity("Redmond");

    /**
     * 방어적인 복사를 하지 않을 경우, Redmond로 변경이 되어버린다.
     */
    System.out.println(person.address.getCity());
  }
}
