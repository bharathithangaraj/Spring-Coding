package hello;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.RedeliveryPolicy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import javax.jms.ConnectionFactory;
import javax.jms.Session;

@SpringBootApplication
@EnableJms
public class Application {

  public static void main(String[] args) {
    // Launch the application
    ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
  }

  @Bean
  public JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory,
                                                  DefaultJmsListenerContainerFactoryConfigurer configurer) {
    DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
    // This provides all boot's default to this factory, including the message converter
    configurer.configure(factory, connectionFactory);
    // You could still override some of Boot's default if necessary.

    // will create maximum of 3 consumer
    factory.setConcurrency("1-3"); // min 1, max 3

    // auto acknowledge
    factory.setSessionAcknowledgeMode(Session.AUTO_ACKNOWLEDGE);
    return factory;
  }


  /**
   * RedeliveryPolicy configures how many time the message is retried to deliver.
   */

  @Bean
  public RedeliveryPolicy redeliveryPolicy() {
    RedeliveryPolicy redeliveryPolicy = new RedeliveryPolicy();
    redeliveryPolicy.setInitialRedeliveryDelay(5000);
    redeliveryPolicy.setBackOffMultiplier(2);
    redeliveryPolicy.setUseExponentialBackOff(true);
    redeliveryPolicy.setMaximumRedeliveries(5);
    return redeliveryPolicy;
  }

  @Bean
  public ConnectionFactory jmsConnectionFactory() {
    ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
    connectionFactory.setRedeliveryPolicy(redeliveryPolicy());
    return connectionFactory;
  }


  @Bean // Serialize message content to json using TextMessage
  public MessageConverter jacksonJmsMessageConverter() {
    MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
    converter.setTargetType(MessageType.TEXT);
    converter.setTypeIdPropertyName("_type");
    return converter;
  }

}
