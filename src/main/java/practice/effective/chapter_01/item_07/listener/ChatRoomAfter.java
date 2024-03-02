package practice.effective.chapter_01.item_07.listener;

import lombok.Getter;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
public class ChatRoomAfter {

  private final WeakList<WeakReference<User>> users;

  public ChatRoomAfter() {
    this.users = new WeakList<>();
  }

  public void addUser(User user) {
    this.users.add(new WeakReference<>(user));
  }

  public void sendMessage(String message) {
    this.users.forEach(wr -> Objects.requireNonNull(wr.get()).receive(message));
  }

}
