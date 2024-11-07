package webCalendarSpring.common.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AddEventRequestDto(@NotBlank String event, @NotNull LocalDate date) {
}
