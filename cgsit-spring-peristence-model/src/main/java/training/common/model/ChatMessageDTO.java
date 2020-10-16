package training.common.model;


import java.io.Serializable;

public class ChatMessageDTO implements Serializable {

  private static final long serialVersionUID = -295422703255886286L;

  private String id;

  private String type;

  //@NotEmpty(message = "{chatMessage.sender.notempty}")
  // @Size(min=5, max=50)
  private String sender;

  private String recipient;

  private String content;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public ChatMessageDTO setType(String type) {
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

  @Override public String toString() {
    return "ChatMessageDTO{" + "id='" + id + '\'' + ", type='" + type + '\'' + ", sender='" + sender + '\'' + ", recipient='" + recipient + '\''
        + ", content='" + content + '\'' + '}';
  }
}
