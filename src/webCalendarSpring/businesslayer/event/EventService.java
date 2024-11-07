package webCalendarSpring.businesslayer.event;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webCalendarSpring.common.exception.NotFoundException;
import webCalendarSpring.common.request.AddEventRequestDto;
import webCalendarSpring.persistence.EventRepository;

@Service
public class EventService {

  private final EventRepository eventRepository;

  public EventService(@Autowired EventRepository eventRepository) {
    this.eventRepository = eventRepository;
  }

  public Event getEventById(Long id) {
    return eventRepository.findById(id).orElseThrow(NotFoundException::new);
  }

  public List<Event> getEvents() {
    return eventRepository.findAll();
  }

  public List<Event> getEventsByDateBetween(LocalDate startDate, LocalDate endDate) {
    return eventRepository.findByDateBetween(startDate, endDate);
  }

  public List<Event> getEventsForToday() {
    return eventRepository.findByDate(LocalDate.now());
  }

  public Event addEvent(@Valid AddEventRequestDto eventRequest) {
    Event event = new Event();
    event.setEvent(eventRequest.event());
    event.setDate(eventRequest.date());
    return eventRepository.save(event);
  }

  public Event deleteEventById(Long id) {
    Event event = getEventById(id);
    eventRepository.delete(event);
    return event;
  }
}
