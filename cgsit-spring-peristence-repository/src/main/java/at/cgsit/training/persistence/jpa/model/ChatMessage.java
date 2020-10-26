package at.cgsit.training.persistence.jpa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class ChatMessage implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Basic(optional = true)
  private MessageType type;

  @Basic(optional = false)
  @Column(name = "content", length = 500, nullable = false)
  private String content;

  @Basic(optional = false)
  @Column(name = "sender", length = 100, nullable = false)
  private String sender;

  @Basic(optional = true)
  @Column(name = "recipient", length = 100, nullable = false)
  private String recipient;

  @Basic(optional = false)
  @Column(name = "erstelldatum", nullable = false)
  private LocalDateTime erstelldatum = LocalDateTime.now();

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }



  public MessageType getType() {
    return type;
  }

  public ChatMessage setType(MessageType type) {
    this.type = type;
    return this;
  }

  public String getContent() {
    return content;
  }

  public ChatMessage setContent(String content) {
    this.content = content;
    return this;
  }

  public String getSender() {
    return sender;
  }

  public ChatMessage setSender(String sender) {
    this.sender = sender;
    return this;
  }

  public String getRecipient() {
    return recipient;
  }

  public ChatMessage setRecipient(String recipient) {
    this.recipient = recipient;
    return this;
  }

  public LocalDateTime getErstelldatum() {
    return erstelldatum;
  }

  public void setErstelldatum(LocalDateTime erstelldatum) {
    this.erstelldatum = erstelldatum;
  }

}
