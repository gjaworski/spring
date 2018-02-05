package jaworskg.spring.jms.receivers;

import jaworskg.spring.jms.model.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JmsTopicSubscriber2 {

    private static final Logger LOGGER = LoggerFactory.getLogger(JmsTopicSubscriber2.class);

    @JmsListener(destination = "jaworskg-topic", containerFactory = "jmsTopicFactory")
    public void subscribeMessage(Email email) {
        LOGGER.info("Received email: {} in {}", email, this.getClass());
    }

}
