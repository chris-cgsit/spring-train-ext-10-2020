package at.cgsit.training.firstexample.exceptions;

public class ChatMessageNotFoundException extends RuntimeException {

  public ChatMessageNotFoundException(Long id) {
    super("Die Chat Nachricht mit der id " + id + " konnte nicht gefunden werden");
  }
}

