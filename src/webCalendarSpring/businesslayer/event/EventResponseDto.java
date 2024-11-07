package webCalendarSpring.businesslayer.event;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EventResponseDto(@NotBlank String event, @NotNull LocalDate date, @NotBlank String message) {
}
