package at.cgsit.training.restendpoint.rest;

import at.cgsit.training.persistence.mongo.config.LoadDatabaseMongoDb;
import at.cgsit.training.persistence.mongo.model.ChatMessageMongoDb;
import at.cgsit.training.persistence.mongo.repository.ChatMessageMongoDbRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@RestController
@RequestMapping("/simplerest")
public class SimpleMongoDbRestController {

  Logger logger = LoggerFactory.getLogger(SimpleMongoDbRestController.class);

  @Autowired
  private ChatMessageMongoDbRepository repository;

  @Autowired
  private LoadDatabaseMongoDb loadDatabaseMongoDb;

  @PreDestroy
  public void preDestroy() {
    logger.info("preDestroy");
  }

  // http://localhost:8080/simplerest/chatmessages

  @PostConstruct
  public void init() {
    logger.info("PostConstruct init pre db update");
    loadDatabaseMongoDb.initDatabase();
    logger.info("PostConstruct init posts db update");
  }


  @GetMapping("/chatmessages")
  public @ResponseBody List<ChatMessageMongoDb> all() {
    return repository.findAll();
  }


  @GetMapping("/chatmessages/{id}") ChatMessageMongoDb one(@PathVariable String id) {
    return repository.findAll().stream().findAny().orElseThrow( () -> new RuntimeException("not found"));
  }

}
