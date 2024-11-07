package webCalendarSpring.common.exception;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EventControllerExceptionHandler {

  @ExceptionHandler({MethodArgumentNotValidException.class})
  public ResponseEntity<Void> handle() {
    return ResponseEntity.badRequest().build();
  }

  @ExceptionHandler({NotFoundException.class})
  public ResponseEntity<Map<String, String>> handleNotFound() {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", "The event doesn't exist!"));
  }

}
