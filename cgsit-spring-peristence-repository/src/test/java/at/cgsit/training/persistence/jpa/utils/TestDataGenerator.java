package at.cgsit.training.persistence.jpa.utils;


import at.cgsit.training.persistence.jpa.model.ChatMessage;
import at.cgsit.training.persistence.jpa.model.MessageType;

/**
 * helper class for chat message test data
 */
public class TestDataGenerator {

  public static ChatMessage getChatMessage() {
    //given
    ChatMessage chatMessage = new ChatMessage();
    chatMessage.setSender("john doe");
    chatMessage.setContent("test ChatMessageDaoTest");
    chatMessage.setRecipient("frank");
    chatMessage.setType(MessageType.CHAT);
    return chatMessage;
  }


}
