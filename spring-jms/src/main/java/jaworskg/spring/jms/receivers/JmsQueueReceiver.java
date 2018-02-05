package jaworskg.spring.jms.receivers;

import jaworskg.spring.jms.model.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JmsQueueReceiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(JmsQueueReceiver.class);

    @JmsListener(destination = "jaworskg-queue", containerFactory = "jmsQueueFactory")
    public void receiveMessage(Email email) {
        LOGGER.info("Received email: {} in {}", email, this.getClass());
    }

}
