package at.cgsit.training.persistence.mongo.model;

import org.springframework.data.annotation.Id;

public class ChatMessageMongoDb {

  @Id
  private String id;

  private MessageType type;

  private String content;

  private String sender;

  private String recipient;

  public void setId(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public MessageType getType() {
    return type;
  }

  public ChatMessageMongoDb setType(MessageType type) {
    this.type = type;
    return this;
  }

  public String getContent() {
    return content;
  }

  public ChatMessageMongoDb setContent(String content) {
    this.content = content;
    return this;
  }

  public String getSender() {
    return sender;
  }

  public ChatMessageMongoDb setSender(String sender) {
    this.sender = sender;
    return this;
  }

  public String getRecipient() {
    return recipient;
  }

  public ChatMessageMongoDb setRecipient(String recipient) {
    this.recipient = recipient;
    return this;
  }
}
