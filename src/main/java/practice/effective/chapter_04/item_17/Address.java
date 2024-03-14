package practice.effective.chapter_04.item_17;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Address {

  private String zipcode;

  private String street;

  private String city;

  public Address(String zipcode, String street, String city) {
    this.zipcode = zipcode;
    this.street = street;
    this.city = city;
  }
}
