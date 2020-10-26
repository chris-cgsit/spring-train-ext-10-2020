package at.cgsit.training.persistence.jpa.dao;


import at.cgsit.training.persistence.jpa.model.ChatMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ChatMessageDao extends AbstractJpaDao<ChatMessage> implements IAbstractJpaDao<ChatMessage> {

  Logger logger = LoggerFactory.getLogger(ChatMessageDao.class);

  public ChatMessageDao(){
    setClazz(ChatMessage.class );
  }

  @Override
  public ChatMessage findOneSpezial(long id) {

    try {
      logger.info("ChatMessageDao find by One {], ", id);

      return super.entityManager.find(ChatMessage.class, id);

    } catch(RuntimeException ex) {
      logger.error("ChatMessageDao find by One {], ", id, ex);
    }
    return null;
  }

}
