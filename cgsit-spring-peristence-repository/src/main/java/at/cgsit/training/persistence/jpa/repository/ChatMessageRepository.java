package at.cgsit.training.persistence.jpa.repository;

import at.cgsit.training.persistence.jpa.model.ChatMessage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * spring data repository
 */
@Repository
// @Profile({"prod"}) // @Profile({"prod", "default"})
public interface ChatMessageRepository extends CrudRepository<ChatMessage, Long> {

  List<ChatMessage> findBySender(String sender);

  @Query( value = "SELECT msg FROM ChatMessage msg WHERE msg.sender LIKE :sender order by msg.erstelldatum desc")
  List<ChatMessage> findByXYZ(@Param("sender") String sender);

}
