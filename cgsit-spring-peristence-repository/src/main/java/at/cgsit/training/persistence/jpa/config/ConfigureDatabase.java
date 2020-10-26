package at.cgsit.training.persistence.jpa.config;

import at.cgsit.training.persistence.jpa.model.ChatMessage;
import at.cgsit.training.persistence.jpa.repository.ChatMessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * only use this if programatic configuration is required by implementing @Bean Constructors
 * otherwise see Autoconfig for properties to configure
 */
@Configuration
@EnableJpaRepositories(basePackages="at.cgsit.training.persistence.jpa.repository")
public class ConfigureDatabase {

  private static final Logger log = LoggerFactory.getLogger(ConfigureDatabase.class);

  @Bean
  public CommandLineRunner initDatabase(ChatMessageRepository repository) {

    ChatMessage chatMessage = new ChatMessage();
    chatMessage.setSender("johnDoe");
    chatMessage.setContent("test");
    chatMessage.setRecipient("franky");

    return args -> {
      log.info("Preloading " + repository.save(chatMessage));
    };
  }
}

