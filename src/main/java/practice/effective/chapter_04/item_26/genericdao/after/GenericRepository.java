package practice.effective.chapter_04.item_26.genericdao.after;

import practice.effective.chapter_04.item_26.genericdao.Entity;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * 제네릭 타입을 사용한 Repository
 */
public class GenericRepository<E extends Entity> {
  private Set<E> set;

  public GenericRepository() {
    this.set = new HashSet<>();
  }

  public Optional<E> findById(Long id) {
    return this.set.stream()
      .filter(a -> a.getId().equals(id))
      .findAny();
  }

  public void add(E message) {
    this.set.add(message);
  }
}
