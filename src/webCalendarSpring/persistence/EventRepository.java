package webCalendarSpring.persistence;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

import webCalendarSpring.businesslayer.event.Event;

public interface EventRepository extends ListCrudRepository<Event, Long> {

  List<Event> findByDate(LocalDate date);

  List<Event> findByDateBetween(LocalDate startDate, LocalDate endDate);

}
