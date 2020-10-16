package at.cgsit.training.persistence.mongo.repository;

import at.cgsit.training.persistence.mongo.config.LoadDatabaseMongoDb;
import at.cgsit.training.persistence.mongo.config.MongoDbConfiguration;
import at.cgsit.training.persistence.mongo.model.ChatMessageMongoDb;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(classes = MongoDbConfiguration.class)
@AutoConfigureDataMongo
class ChatMessageMongoDbRepositoryTest {

  @Autowired
  private ChatMessageMongoDbRepository repository;

  @Test void testMongoDbAdd() {
    ChatMessageMongoDb chatMessageMongoDb = LoadDatabaseMongoDb.ceateMongoDbChatMessage();

    ChatMessageMongoDb save = repository.save(chatMessageMongoDb);
    assertThat(save).isNotNull();

  }

  @Test void testMongoDbFindAll() {
    List<ChatMessageMongoDb> allMessageMongoDbs = repository.findAll();
    assertThat(allMessageMongoDbs).isNotNull();
  }

  @Test void testMongoDbFindByName() {

    List<ChatMessageMongoDb> resultList = repository.findBySender("johnDoe");
    assertThat(resultList).isNotNull();

  }


}




