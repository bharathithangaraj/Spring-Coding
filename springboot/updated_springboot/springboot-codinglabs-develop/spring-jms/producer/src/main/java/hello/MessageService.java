package hello;

import org.apache.activemq.ScheduledMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.QosSettings;
import org.springframework.stereotype.Service;

import javax.jms.DeliveryMode;

@Service("emailService")
public class MessageService {

  @Autowired
  JmsTemplate jmsTemplate;

  public void send(Email email) {
    // Quality of Service settings
    QosSettings replyQosSettings = new QosSettings();
    replyQosSettings.setPriority(2);
//    replyQosSettings.setTimeToLive(10000);
    replyQosSettings.setDeliveryMode(DeliveryMode.PERSISTENT);
    jmsTemplate.setQosSettings(replyQosSettings);

//    jmsTemplate.setDeliveryDelay(10000L);

    int delay = 1000 * 60;
    jmsTemplate.convertAndSend("mailbox", email, m -> {
      m.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, 10000);
      return m;
    });
  }

}
