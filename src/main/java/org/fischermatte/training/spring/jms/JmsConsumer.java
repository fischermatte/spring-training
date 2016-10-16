package org.fischermatte.training.spring.jms;

import org.springframework.jms.annotation.JmsListener;

import static org.fischermatte.training.spring.jms.JmsConfig.EMAIL_QUEUE_DESTINATION;
import static org.fischermatte.training.spring.jms.JmsConfig.TEXT_QUEUE_DESTINATION;

public class JmsConsumer {

    @JmsListener(destination = TEXT_QUEUE_DESTINATION)
    public void onReceiveMessage(String text) {
            System.out.println("Received <" + text + ">");
    }

    @JmsListener(destination = EMAIL_QUEUE_DESTINATION)
    public void onReceiveMessage(Email email) {
        System.out.println("Received <" + email.getText() + ">");
    }

}
