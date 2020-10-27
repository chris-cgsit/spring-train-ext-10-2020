package at.cgsit.training.common.jms.config;


/**
 *
 * https://b-82914f3e-4b6c-4670-b433-9138ff4d38a5-1.mq.eu-west-1.amazonaws.com:8162/admin/queues.jsp
 *
 * pring.activemq.user=cgsDemoBrokerUser
 * spring.activemq.password=cgsDemoBroker1224
 *
 * QUEUE name could also be read via property from config file
 */
public interface ChatMessageConstants {

  String CHAT_MESSAGE_QUEUE = "test_chris_schaefer";

}
