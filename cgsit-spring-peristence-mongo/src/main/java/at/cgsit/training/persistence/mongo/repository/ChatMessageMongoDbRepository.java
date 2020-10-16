package at.cgsit.training.persistence.mongo.repository;

import at.cgsit.training.persistence.mongo.model.ChatMessageMongoDb;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatMessageMongoDbRepository extends MongoRepository<ChatMessageMongoDb, String> {

  List<ChatMessageMongoDb> findBySender(String sender);


}
