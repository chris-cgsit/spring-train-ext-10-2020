package at.cgsit.training.firstexample.services;

import at.cgsit.training.firstexample.dto.ChatMessageDTO;
import at.cgsit.training.persistence.jpa.model.ChatMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@Transactional
// @Profile("dummy")
public class DevChatMessageServiceImpl implements ChatMessageService {

  Logger logger = LoggerFactory.getLogger(DevChatMessageServiceImpl.class);

  @Override
  public List<ChatMessage> listAll() {
    logger.info("listall");
    return Collections.emptyList();
  }

  @Override public ChatMessage getById(Long id) {
    logger.info("getById");
    return null;
  }

  @Override public List<ChatMessage> findBySender(String sender) {
    logger.info("findBySender");
    return Collections.EMPTY_LIST;
  }

  @Override public ChatMessage saveOrUpdate(ChatMessage chatMessage) {
    logger.info("saveOrUpdate");
    return null;
  }

  @Override public void delete(Long id) {
    logger.info("delete");
  }

  @Override public ChatMessage saveOrUpdateChatMessageDTO(ChatMessageDTO cmDTO) {
    logger.info("delete");
    return null;
  }

}
