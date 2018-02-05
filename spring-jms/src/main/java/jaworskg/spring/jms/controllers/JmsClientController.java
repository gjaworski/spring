package jaworskg.spring.jms.controllers;

import jaworskg.spring.jms.model.Email;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JmsClientController {

    private final JmsTemplate jmsQueueTemplate;
    private final JmsTemplate jmsTopicTemplate;

    JmsClientController(JmsTemplate jmsQueueTemplate, JmsTemplate jmsTopicTemplate) {
        this.jmsQueueTemplate = jmsQueueTemplate;
        this.jmsTopicTemplate = jmsTopicTemplate;
    }

    @GetMapping("/queue/email")
    public ResponseEntity<String> sendEmailToQueue(@RequestParam("body") String emailBody) {
        jmsQueueTemplate.convertAndSend("jaworskg-queue", new Email("info@example.com", emailBody));
        return ResponseEntity.ok("Email sent to queue!");
    }

    @GetMapping("/topic/email")
    public ResponseEntity<String> sendEmailToTopic(@RequestParam("body") String emailBody) {
        jmsTopicTemplate.convertAndSend("jaworskg-topic", new Email("info@example.com", emailBody));
        return ResponseEntity.ok("Email sent to topic!");
    }

}
