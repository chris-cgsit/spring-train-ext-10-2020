package at.cgsit.training.restendpoint.rest;

import at.cgsit.training.persistence.mongo.model.ChatMessageMongoDb;
import at.cgsit.training.persistence.mongo.repository.ChatMessageMongoDbRepository;
import at.cgsit.training.restendpoint.jmsmessaging.send.ChatMessageSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import training.common.model.ChatMessageDTO;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@RestController
@RequestMapping("/jms")
public class SimpleJmsChatMesasageRestController {

  Logger logger = LoggerFactory.getLogger(SimpleJmsChatMesasageRestController.class);

  @Autowired
  private ChatMessageMongoDbRepository repository;

  @Autowired ChatMessageSender chatMessageSender;

  @PreDestroy
  public void preDestroy() {
    logger.info("preDestroy");
  }

  @PostConstruct
  public void init() {
    logger.info("PostConstruct init ");

  }

  @GetMapping("/sendmessage/{id}") ChatMessageMongoDb one(@PathVariable String id) {

    ChatMessageMongoDb chatMessage = repository.findAll().stream().findAny().orElseThrow(() -> new RuntimeException("not found"));

    ChatMessageDTO cmDTO = new ChatMessageDTO();
    cmDTO.setId(chatMessage.getId());
    cmDTO.setSender(chatMessage.getSender());
    cmDTO.setRecipient(chatMessage.getRecipient());
    cmDTO.setContent(chatMessage.getContent());

    chatMessageSender.send(cmDTO);

    return chatMessage;

    /*return chatMessageMongoDbRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("error with id not found"));
     */
  }

}
