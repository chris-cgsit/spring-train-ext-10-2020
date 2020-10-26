package at.cgsit.training.firstexample.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ChatMessageDTO {

  private Long id;

  @NotNull
  private MessageType type;

  @NotEmpty(message = "{chatMessage.sender.notempty}")
  @Size(min=5, max=50)
  private String sender;

  @NotNull
  @Size(min=5, max=50)
  private String recipient;

  @NotNull
  @Size(min=5, max=50)
  private String content;


  public enum MessageType {
    CHAT,
    PRIVATE,
    JOIN,
    LEAVE;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public MessageType getType() {
    return type;
  }

  public ChatMessageDTO setType(MessageType type) {
    this.type = type;
    return this;
  }

  public String getContent() {
    return content;
  }

  public ChatMessageDTO setContent(String content) {
    this.content = content;
    return this;
  }

  public String getSender() {
    return sender;
  }

  public ChatMessageDTO setSender(String sender) {
    this.sender = sender;
    return this;
  }

  public String getRecipient() {
    return recipient;
  }

  public ChatMessageDTO setRecipient(String recipient) {
    this.recipient = recipient;
    return this;
  }
}
