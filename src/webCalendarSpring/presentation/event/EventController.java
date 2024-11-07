package webCalendarSpring.presentation.event;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import webCalendarSpring.businesslayer.event.Event;
import webCalendarSpring.businesslayer.event.EventResponseDto;
import webCalendarSpring.businesslayer.event.EventService;
import webCalendarSpring.common.request.AddEventRequestDto;

@RestController
public class EventController {

  private final EventService eventService;

  public EventController(@Autowired EventService eventService) {
    this.eventService = eventService;
  }

  @GetMapping("/event/{id}")
  public ResponseEntity<Event> getEventById(@PathVariable Long id) {
    Event event = eventService.getEventById(id);
    return ResponseEntity.ok().body(event);
  }

  @GetMapping("/event")
  public ResponseEntity<List<Event>> getEvents(
      @RequestParam("start_time") Optional<LocalDate> startTime,
      @RequestParam("end_time") Optional<LocalDate> endTime
  ) {
    List<Event> events;
    if (startTime.isPresent() && endTime.isPresent()) {
      events = eventService.getEventsByDateBetween(startTime.get(), endTime.get());
    } else {
      events = eventService.getEvents();
    }
    return events.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(events);
  }

  @GetMapping("/event/today")
  public List<Event> getEventsForToday() {
    return eventService.getEventsForToday();
  }

  @PostMapping("/event")
  public ResponseEntity<EventResponseDto> addEvent(@Valid @RequestBody AddEventRequestDto eventRequest) {
    Event event = eventService.addEvent(eventRequest);
    return ResponseEntity.status(HttpStatus.OK).body(new EventResponseDto(event.getEvent(), event.getDate(), "The event has been added!"));
  }

  @DeleteMapping("/event/{id}")
  public ResponseEntity<Event> deleteEventById(@PathVariable Long id) {
    Event event = eventService.deleteEventById(id);
    return ResponseEntity.ok().body(event);
  }

}
