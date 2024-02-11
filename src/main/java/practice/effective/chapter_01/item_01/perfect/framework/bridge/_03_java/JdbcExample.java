package practice.effective.chapter_01.item_01.perfect.framework.bridge._03_java;

import java.sql.*;

public class JdbcExample {

  public static void main(String[] args) throws ClassNotFoundException {
    Class.forName("org.h2.Driver");

    try(Connection conn = DriverManager.getConnection("jdbc:h2:mem:~/test", "sa", "")) {
      String sql = "CREATE TABLE ACCOUNT " +
        "(id INTEGER not NULL, " +
        " email VARCHAR(255), " +
        " password VARCHAR(255), " +
        " PRIMARY KEY ( id ))";

      Statement statement = conn.createStatement();
      statement.execute(sql);

      ResultSet resultSet = statement.executeQuery(sql);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
