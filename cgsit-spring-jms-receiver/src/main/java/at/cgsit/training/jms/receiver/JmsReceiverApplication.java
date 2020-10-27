package at.cgsit.training.jms.receiver;

// import at.cgsit.training.common.model.ChatMessageDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;


@SpringBootApplication
@ComponentScan(basePackages="at.cgsit")
public class JmsReceiverApplication {

  static Logger logger = LoggerFactory.getLogger(JmsReceiverApplication.class);

    public static void main(String[] args) {
      SpringApplication app = new SpringApplication(JmsReceiverApplication.class);
  	  app.setBannerMode(Banner.Mode.LOG);
      ConfigurableApplicationContext context = app.run(args);
    }

  @Bean // Serialize message content to json using TextMessage
  public MessageConverter jacksonJmsMessageConverter() {
    MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
    converter.setTargetType(MessageType.TEXT);
    converter.setTypeIdPropertyName("_type");
    return converter;
  }

}
