package practice.effective.chapter_01.item_03.perfect.serialization;

import java.io.*;
import java.time.LocalDate;

public class Example {

  private void serialize(Book book) {
    try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("book.obj"))) {
      out.writeObject(book);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private Book deserialize() {
    try (ObjectInput in = new ObjectInputStream(new FileInputStream("book.obj"))) {
      return (Book) in.readObject();
    } catch (IOException | ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  public static void main(String[] args) {
    Book book = new Book("12345", "이펙티브 자바 완벽 공략", "지누리즈", LocalDate.of(2022, 3, 21));
    book.setNumberOfSold(200);
    Book.name = "jinuliz";  // 직렬화 되지 않는다.

    Example example = new Example();
    example.serialize(book);
    Book.name = "lizjinu";
    Book deserialize = example.deserialize();

    System.out.println(book);
    System.out.println(deserialize);
  }

}
