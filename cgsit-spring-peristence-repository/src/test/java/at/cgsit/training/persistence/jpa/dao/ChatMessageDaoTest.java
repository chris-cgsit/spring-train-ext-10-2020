package at.cgsit.training.persistence.jpa.dao;

import at.cgsit.training.persistence.jpa.config.ConfigureDatabase;
import at.cgsit.training.persistence.jpa.model.ChatMessage;
import at.cgsit.training.persistence.jpa.utils.TestDataGenerator;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = ConfigureDatabase.class)
@EntityScan("at.cgsit.training.persistence.jpa.*")
@ComponentScan(basePackages="at.cgsit")
class ChatMessageDaoTest {
  Logger logger = LoggerFactory.getLogger(ChatMessageDaoTest.class);

  @Autowired
  private IAbstractJpaDao<ChatMessage> chatMessageDao;

  @Test
  public void testCustomConnection() {

    ChatMessage oneSpezial = chatMessageDao.findOneSpezial(1);
    // assertThat(oneSpezial).isNotNull();
    if(oneSpezial==null) {
      logger.info("testCustomConnection");
    }
  }

  @Test
  public void testPersistence() {
    ChatMessage chatMessage = TestDataGenerator.getChatMessage();
    chatMessageDao.create(chatMessage);
    ChatMessage newChatMessage1 = chatMessageDao.findOne(chatMessage.getId());
    assertThat( newChatMessage1.getId() ).isGreaterThanOrEqualTo(1L);
  }

  @SpringBootApplication
  public static class TestConfiguration {
  }

}
