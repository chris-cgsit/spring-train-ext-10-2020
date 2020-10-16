package at.cgsit.training.persistence.mongo.repository;

import at.cgsit.training.persistence.mongo.model.ChatMessageMongoDb;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatMessageMongoDbRepository extends MongoRepository<ChatMessageMongoDb, String> {

    public ChatMessageMongoDb findBySender(String sender);

  }
