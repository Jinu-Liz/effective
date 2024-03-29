package practice.effective.chapter_04.item_26.genericdao.before;

import practice.effective.chapter_04.item_26.genericdao.Schedule;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Entity가 늘어나고 Repository가 추가되면
 * 같은 코드가 반복되게 된다.
 */
public class ScheduleRepository {

  private Set<Schedule> schedule;

  public ScheduleRepository() {
    this.schedule = new HashSet<>();
  }

  public Optional<Schedule> findById(Long id) {
    return this.schedule.stream()
      .filter(a -> a.getId().equals(id))
      .findAny();
  }

  public void add(Schedule schedule) {
    this.schedule.add(schedule);
  }
}
