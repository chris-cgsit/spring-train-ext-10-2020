package at.cgsit.training.restendpoint.jmsmessaging.receive;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

@Configuration
@EnableJms
public class JmsReceiverConfig {

  @Value("${activemq.broker-url}")
  private String brokerUrl;

  @Bean
  public ActiveMQConnectionFactory receiverActiveMQConnectionFactory() {

    ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
    factory.setBrokerURL(brokerUrl);
    factory.setUserName("cgsDemoBrokerUser");
    factory.setPassword("cgsDemoBroker1224");

    return factory;
  }

  @Bean
  public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {

    DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
    factory.setConnectionFactory(receiverActiveMQConnectionFactory());

    return factory;
  }

  @Bean
  public ChatMessageDtoJmsReceiver receiver() {
    return new ChatMessageDtoJmsReceiver();
  }
}
