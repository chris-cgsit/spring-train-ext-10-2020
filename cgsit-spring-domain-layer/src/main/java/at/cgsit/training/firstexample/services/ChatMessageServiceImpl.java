package at.cgsit.training.firstexample.services;

import at.cgsit.training.firstexample.dto.ChatMessageDTO;
import at.cgsit.training.firstexample.translator.ChatMessageDTOToChatMessage;
import at.cgsit.training.persistence.jpa.model.ChatMessage;
import at.cgsit.training.persistence.jpa.repository.ChatMessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
@Transactional(propagation = Propagation.REQUIRED)
public class ChatMessageServiceImpl implements ChatMessageService {

  Logger logger = LoggerFactory.getLogger(ChatMessageServiceImpl.class);

  private ChatMessageRepository chatMessageRepository;

  private ChatMessageDTOToChatMessage chatMessageDTOToChatMessage;


  @Autowired
  public ChatMessageServiceImpl(ChatMessageRepository chatMessageRepository, ChatMessageDTOToChatMessage chatMessageDTOToChatMessage) {
    this.chatMessageRepository = chatMessageRepository;
    this.chatMessageDTOToChatMessage = chatMessageDTOToChatMessage;
  }


  @Override
  public List<ChatMessage> listAll() {
    List<ChatMessage> messages = new ArrayList<>();
    chatMessageRepository.findAll().forEach(messages::add);
    return messages;
  }

  @Override
  public ChatMessage getById(Long id) {
    return chatMessageRepository.findById(id).orElse(null);
  }

  @Override
  public List<ChatMessage> findBySender(String sender) {
    return chatMessageRepository.findBySender(sender);
  }

  @Override
  public ChatMessage saveOrUpdate(ChatMessage product) {
    chatMessageRepository.save(product);
    return product;
  }

  @Override
  public void delete(Long id) {
    chatMessageRepository.deleteById(id);

  }

  @Override
  public ChatMessage saveOrUpdateChatMessageDTO(ChatMessageDTO cmDTO){
    ChatMessage savedMessage = saveOrUpdate(chatMessageDTOToChatMessage.convert(cmDTO));

    if(savedMessage.getSender().equalsIgnoreCase("Gesperrt")) {
      throw new RuntimeException("Dieser User ist gesperrt");
    }

    logger.info("Saved Chat Message Id: {}", savedMessage.getId());
    return savedMessage;
  }



}
