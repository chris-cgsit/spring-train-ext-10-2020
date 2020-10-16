package at.cgsit.training.restendpoint.jmsmessaging.receive;

import at.cgsit.training.restendpoint.jmsmessaging.config.ChatMessageConstants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import training.common.model.ChatMessageDTO;

@Component
public class ChatMessageDtoJmsReceiver {

  Logger logger = LoggerFactory.getLogger(ChatMessageDtoJmsReceiver.class);

  @JmsListener(destination = ChatMessageConstants.CHAT_MESSAGE_QUEUE )  // , containerFactory = "myFactory")
  public void receiveMessage(String reseived) throws JsonProcessingException {
    logger.info(" - JMS ------- Received String {}", reseived);

    ChatMessageDTO chatMessageDTO = (ChatMessageDTO)new ObjectMapper().readValue(reseived, ChatMessageDTO.class);

    logger.info("Received {}", chatMessageDTO.toString());
    logger.info(" - JMS ------- END ");

  }

}
