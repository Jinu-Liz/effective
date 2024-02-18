package practice.effective.chapter_01.item_03.perfect.serialization;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Serializable을 구현한 Class에 JVM 런타임 시, serialVersionUID같은 고유번호를 부여한다.
 * 만약 Class에 인스턴스가 없어지거나 추가되는 등의 변경이 일어나는 경우, 이 고유번호가 변경된다.
 * 따라서 직렬화 후, Class에 변경이 일어나면 역직렬화 시 고유번호가 맞지 않으므로 에러가 발생한다.
 *
 * 따라서 변경이 생겨도 역직렬화를 하고 싶은 경우에는, serialVersionUID를 동일하게 유지시켜주면 된다.
 * EX) public static final long serialVersionUID = 1L;
 */
@Data
public class Book implements Serializable {

  // 변경이 일어나도 역직렬화를 하기 위해 선언.
  public static final long serialVersionUID = 1L;

  /**
   * public static의 경우, 클래스에 할당되는 값이지, 인스턴스에 해당하는 값이 아니기 때문에
   * 직렬화가 되지 않는다.
   */
  public static String name;

  private String isbn;

  private String title;

  private String author;

  private LocalDate published;

  // 직렬화를 하고 싶지 않는 경우, transient 사용
  private transient int numberOfSold;

  public Book(String isbn, String title, String author, LocalDate published) {
    this.isbn = isbn;
    this.title = title;
    this.author = author;
    this.published = published;
  }

  @Override
  public String toString() {
    return "Book{" +
      "isbn='" + isbn + '\'' +
      ", title='" + title + '\'' +
      ", author='" + author + '\'' +
      ", published=" + published +
      ", numberOfSold=" + numberOfSold +
      ", name=" + name +
      '}';
  }
}
