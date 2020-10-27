package at.cgsit.training.restendpoint.jmsmessaging.send;

import at.cgsit.training.firstexample.dto.ChatMessageDTO;
import at.cgsit.training.common.jms.config.ChatMessageConstants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;


@Component
public class ChatMessageSender {

    private static final Logger LOGGER =  LoggerFactory.getLogger(ChatMessageSender.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    public void send(ChatMessageDTO message) {
      LOGGER.info("sending message='{}'", message);
      String writeValueAsString;
      try {
        writeValueAsString = new ObjectMapper().writeValueAsString(message);
      } catch (JsonProcessingException ex ) {
        throw new RuntimeException(ex);
      }

      jmsTemplate.convertAndSend(ChatMessageConstants.CHAT_MESSAGE_QUEUE, writeValueAsString);

    }

}


