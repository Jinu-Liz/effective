package practice.effective.chapter_04.item_26.genericdao.after;

import practice.effective.chapter_04.item_26.genericdao.Message;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class MessageRepository {

  private Set<Message> messages;

  public MessageRepository() {
    this.messages = new HashSet<>();
  }

  public Optional<Message> findById(Long id) {
    return this.messages.stream()
      .filter(a -> a.getId().equals(id))
      .findAny();
  }

  public void add(Message message) {
    this.messages.add(message);
  }
}
