package org.fischermatte.training.spring.jms;


import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;

import static org.fischermatte.training.spring.jms.JmsConfiguration.EMAIL_QUEUE_DESTINATION;

public class JmsProducer {

    private final JmsMessagingTemplate jmsMessagingTemplate;
    private final JmsTemplate jmsTemplate;
    private final Queue textQueue;
    private final Queue emailQueue;

    public JmsProducer(JmsMessagingTemplate jmsMessagingTemplate, JmsTemplate jmsTemplate, Queue textQueue, Queue emailQueue) {
        this.jmsMessagingTemplate = jmsMessagingTemplate;
        this.jmsTemplate = jmsTemplate;
        this.textQueue = textQueue;
        this.emailQueue = emailQueue;
    }

    public void doSomeJms() {
        jmsMessagingTemplate.convertAndSend(textQueue, "huhu");
        jmsMessagingTemplate.convertAndSend(emailQueue, new Email("huhu", "text"));
        sendWithMessageCreator();
        sendWithProducerCallback();
        sendWithSessionCallback();
    }

    private void sendWithMessageCreator() {
        jmsTemplate.send(EMAIL_QUEUE_DESTINATION, session -> {
            ObjectMessage objectMessage = session.createObjectMessage();
            objectMessage.setObject(new Email("subj", "text"));
            return objectMessage;
        });
    }


    private void sendWithProducerCallback() {
        jmsTemplate.execute(EMAIL_QUEUE_DESTINATION, (session, producer) -> {
            ObjectMessage objectMessage = session.createObjectMessage();
            objectMessage.setObject(new Email("subj", "text"));
            producer.send(objectMessage);
            return (Email) objectMessage.getObject();
        });
    }

    private void sendWithSessionCallback() {
        jmsTemplate.execute(session -> {
            MessageProducer producer = session.createProducer(emailQueue);
            ObjectMessage objectMessage = session.createObjectMessage();
            objectMessage.setObject(new Email("subj", "text"));
            producer.send(objectMessage);
            return (Email) objectMessage.getObject();
        });
    }
}
