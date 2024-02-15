package practice.effective.chapter_01.item_03.field;

import java.io.*;

public class ElvisSerialization {
  public static void main(String[] args) {
    try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("elvis.obj"))) {
      out.writeObject(Elvis.INSTANCE);
    } catch (IOException e) {
      e.printStackTrace();
    }

    try (ObjectInput in = new ObjectInputStream(new FileInputStream("elvis.obj"))) {
      Elvis elvis = (Elvis) in.readObject();
      System.out.println(elvis == Elvis.INSTANCE);
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

}
