package org.fischermatte.training.spring.jms;


import org.springframework.jms.core.JmsMessagingTemplate;

import javax.jms.Queue;

public class JmsProducer {

    private final JmsMessagingTemplate jmsMessagingTemplate;
    private final Queue textQueue;
    private final Queue emailQueue;

    public JmsProducer(JmsMessagingTemplate jmsMessagingTemplate, Queue textQueue, Queue emailQueue) {
        this.jmsMessagingTemplate = jmsMessagingTemplate;
        this.textQueue = textQueue;
        this.emailQueue = emailQueue;
    }

    public void doSomeJms() {
        jmsMessagingTemplate.convertAndSend(textQueue, "huhu");
        jmsMessagingTemplate.convertAndSend(emailQueue, new Email("huhu", "text"));
    }
}
