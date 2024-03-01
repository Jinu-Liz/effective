package practice.effective.chapter_01.item_07.listener;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ChatRoom {

  private List<WeakReference<User>> users;

  public ChatRoom() {
    this.users = new ArrayList<>();
  }

  public void addUser(User user) {
    this.users.add(new WeakReference<>(user));
  }

  public void sendMessage(String message) {
    this.users.forEach(wr -> Objects.requireNonNull(wr.get()).receive(message));
  }

  public List<WeakReference<User>> getUsers() {
    return this.users;
  }
}
