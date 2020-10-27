package at.cgsit.training.firstexample.service.mongodb;

import at.cgsit.training.firstexample.dto.ChatMessageDTO;
import at.cgsit.training.firstexample.translator.ChatMessageDTOToChatMessageMongoDb;
import at.cgsit.training.persistence.jpa.model.ChatMessage;
import at.cgsit.training.persistence.mongo.model.ChatMessageMongoDb;
import at.cgsit.training.persistence.mongo.repository.ChatMessageMongoDbRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * TODO make one common Domain service api and impl for jpa and or mongo db s
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ChatMessageMongoDbService {

  Logger logger = LoggerFactory.getLogger(ChatMessageMongoDbService.class);

  private ChatMessageMongoDbRepository repository;

  private ChatMessageDTOToChatMessageMongoDb translator;


  @Autowired
  public ChatMessageMongoDbService(ChatMessageMongoDbRepository repository, ChatMessageDTOToChatMessageMongoDb chatMessageDTOToChatMessage) {
    this.repository = repository;
    this.translator = chatMessageDTOToChatMessage;
  }

  public List<ChatMessageMongoDb> findBySender(String sender) {
    return repository.findBySender(sender);
  }

  public ChatMessageMongoDb saveOrUpdate(ChatMessageMongoDb product) {
    repository.save(product);
    return product;
  }

  public ChatMessageMongoDb saveOrUpdateChatMessageDTO(ChatMessageDTO cmDTO){
    ChatMessageMongoDb savedMessage = saveOrUpdate(translator.convert(cmDTO));

    if(savedMessage.getSender().equalsIgnoreCase("Gesperrt")) {
      throw new RuntimeException("Dieser User ist gesperrt");
    }

    logger.info("Saved Chat Message Id: {}", savedMessage.getId());
    return savedMessage;
  }

}
