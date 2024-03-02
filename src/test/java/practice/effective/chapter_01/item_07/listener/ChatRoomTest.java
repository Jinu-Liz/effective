package practice.effective.chapter_01.item_07.listener;

import org.junit.jupiter.api.Test;

import java.lang.ref.WeakReference;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ChatRoomTest {

  @Test
  void chatRoom() throws InterruptedException {
    ChatRoom chatRoom = new ChatRoom();
    User user1 = new User();
    User user2 = new User();

    chatRoom.addUser(user1);
    chatRoom.addUser(user2);

    chatRoom.sendMessage("hello");
    user1 = null;
    System.gc();

    Thread.sleep(5000L);

    /**
     * WeakReference에는 참조 해제된 객체를 지우는 기능이 없다.
     * 해당 기능은 WeakHashMap에 있기 때문.
     * 따라서 리스트에서 삭제하기 위해서는 해제된 객체를 지우는 List를 별도로 구현해야한다.
     */
    List<WeakReference<User>> users = chatRoom.getUsers();
    assertTrue(users.size() == 1);
  }

  @Test
  void chatRoomAfter() throws InterruptedException {
    ChatRoomAfter chatRoom = new ChatRoomAfter();
    User user1 = new User();
    User user2 = new User();

    chatRoom.addUser(user1);
    chatRoom.addUser(user2);

    chatRoom.sendMessage("hello");

    user1 = null;
    System.gc();

    Thread.sleep(5000L);

    /**
     * WeakList를 별도로 구현하여 객체가 해제되었을 경우, 리스트에서 삭제한다.
     */
    WeakList<WeakReference<User>> users = chatRoom.getUsers();
    assertTrue(users.size() == 1);
  }
}