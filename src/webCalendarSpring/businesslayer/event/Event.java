package webCalendarSpring.businesslayer.event;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public final class Event {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  private String event;

  @NotNull
  private LocalDate date;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public @NotNull String getEvent() {
    return event;
  }

  public void setEvent(@NotNull String event) {
    this.event = event;
  }

  public @NotNull LocalDate getDate() {
    return date;
  }

  public void setDate(@NotNull LocalDate date) {
    this.date = date;
  }
}
