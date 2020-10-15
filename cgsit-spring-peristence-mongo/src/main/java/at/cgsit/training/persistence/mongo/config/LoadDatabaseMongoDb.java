package at.cgsit.training.persistence.mongo.config;

import at.cgsit.training.persistence.mongo.model.ChatMessageMongoDb;
import at.cgsit.training.persistence.mongo.repository.ChatMessageMongoDbRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class LoadDatabaseMongoDb {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabaseMongoDb.class);

  @Autowired
  private ChatMessageMongoDbRepository chatMessageMongoDbRepository;

  public void initDatabase() {

    ChatMessageMongoDb chatMessage = new ChatMessageMongoDb();
    chatMessage.setSender("johnDoe");
    chatMessage.setRecipient("franky");
    chatMessage.setContent("test from MongoDB");

     log.info("Preloading " + chatMessageMongoDbRepository.save(chatMessage));
  }
}

