package at.cgsit.training.restendpoint.jmsmessaging.send;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class JmsSenderConfiguration {

    @Value("${activemq.broker-url}")
    private String brokerUrl;

    @Bean
    public ActiveMQConnectionFactory senderActiveMQConnectionFactory() {

      ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
      factory.setBrokerURL(brokerUrl);
      factory.setUserName("cgsDemoBrokerUser");
      factory.setPassword("cgsDemoBroker1224");

      return factory;
    }

    @Bean
    public CachingConnectionFactory cachingConnectionFactory() {
      return new CachingConnectionFactory(senderActiveMQConnectionFactory());
    }

    @Bean
    public JmsTemplate jmsTemplate() {
      return new JmsTemplate(cachingConnectionFactory());
    }

    @Bean
    public ChatMessageSender sender() {
      return new ChatMessageSender();
    }
  }
