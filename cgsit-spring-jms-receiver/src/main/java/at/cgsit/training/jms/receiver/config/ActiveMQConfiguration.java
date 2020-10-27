package at.cgsit.training.jms.receiver.config;

import org.apache.activemq.ActiveMQSslConnectionFactory;
import org.springframework.beans.factory.annotation.Value;

/**
 * use this to configure factory with SSL credentials
 * the simple ActiveMQ AWS Server does not require ssl out of the boxs
 */
// @ Configuration
public class ActiveMQConfiguration {

  // @Bean
  public ActiveMQSslConnectionFactory activeMQSslConnectionFactory(
      @Value("${activemq.broker-url}") String brokerUrl
      //@Value("${spring.activemq.ssl.trustStorePath}") String trustStorePath,
      //@Value("${spring.activemq.ssl.trustStorePass}") String trustStorePass,
      //@Value("${spring.activemq.ssl.keyStorePath}") String keyStorePath,
      //@Value("${spring.activemq.ssl.keyStorePass}") String keyStorePass
      ) throws Exception {

    ActiveMQSslConnectionFactory factory = new ActiveMQSslConnectionFactory(brokerUrl);

    // factory.setUserName("cgsDemoBrokerUser");
    // factory.setPassword("cgsDemoBroker1224");

    //factory.setTrustStore(trustStorePath);
    //factory.setTrustStorePassword(trustStorePass);
    //factory.setKeyStore(keyStorePath);
    //factory.setKeyStorePassword(keyStorePass);

    return factory;
  }
}

