package at.cgsit.training.firstexample.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ChatMessageNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(ChatMessageNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String employeeNotFoundHandler(ChatMessageNotFoundException ex) {
    return ex.getMessage();
  }
}
