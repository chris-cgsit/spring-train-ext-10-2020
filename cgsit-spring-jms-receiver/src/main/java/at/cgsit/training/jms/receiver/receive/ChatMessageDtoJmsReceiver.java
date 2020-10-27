package at.cgsit.training.jms.receiver.receive;

import at.cgsit.training.common.jms.config.ChatMessageConstants;
import at.cgsit.training.firstexample.dto.ChatMessageDTO;
import at.cgsit.training.persistence.mongo.repository.ChatMessageMongoDbRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ChatMessageDtoJmsReceiver {
    Logger logger = LoggerFactory.getLogger(ChatMessageDtoJmsReceiver.class);

    @Autowired
    private ChatMessageMongoDbRepository repository;

    @JmsListener(destination = ChatMessageConstants.CHAT_MESSAGE_QUEUE)  // , containerFactory = "myFactory")
    public void receiveMessage(String reseived) throws JsonProcessingException {

        logger.info(" - JMS ------- Received String {}", reseived);

        ChatMessageDTO chatMessageDTO = (ChatMessageDTO) new ObjectMapper().readValue(reseived, ChatMessageDTO.class);

        logger.info("Received {}", chatMessageDTO.toString());
        logger.info(" - JMS ------- END ");
    }

}
