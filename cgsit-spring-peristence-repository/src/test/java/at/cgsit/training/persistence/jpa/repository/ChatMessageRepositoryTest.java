package at.cgsit.training.persistence.jpa.repository;

import at.cgsit.training.persistence.jpa.config.ConfigureDatabase;
import at.cgsit.training.persistence.jpa.model.ChatMessage;
import at.cgsit.training.persistence.jpa.utils.TestDataGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


//@DataJpaTest
@SpringBootTest(classes = ConfigureDatabase.class)
@AutoConfigureDataJpa
public class ChatMessageRepositoryTest {

  Logger logger = LoggerFactory.getLogger(ChatMessageRepositoryTest.class);

  @Autowired
  private ChatMessageRepository chatMessageRepository;

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @BeforeEach
  public void tearDown() {
      // use Jdbc Test Template to cleanup or modify database and test data
      // JdbcTestUtils.deleteFromTables(jdbcTemplate, "chat_message");
  }

  @Test
  public void testFindBySenderWithOrderBy() {

    List<ChatMessage> bySender = chatMessageRepository.findByXYZ("Chris");

    bySender.stream().forEach( e -> logger.info("sender {} time {}", e.getSender(), e.getErstelldatum() ));

    assertThat(bySender).isNotNull();
    // assertThat(bySender.size()).isGreaterThan(1);
  }


  @Test
  public void testFindBySender() {
    List<ChatMessage> bySender = chatMessageRepository.findBySender("Chris");
    assertThat(bySender).isNotNull();
    // assertThat(bySender.size()).isGreaterThan(0);
  }


  @Test
  public void testPersistence() {

    ChatMessage chatMessage = TestDataGenerator.getChatMessage();

    //when
    ChatMessage saved = chatMessageRepository.save(chatMessage);

    chatMessage.setSender("Chris");
    chatMessage.setId(null);
    chatMessageRepository.save(chatMessage);

    assertThat(saved.getId()).isNotNull();
    assertThat(chatMessage.getId()).isNotNull();

    ChatMessage newChatMessage1 = chatMessageRepository.findById(chatMessage.getId()).orElse(null);
    assertThat( newChatMessage1.getId() ).isGreaterThanOrEqualTo(1L);
  }

}

