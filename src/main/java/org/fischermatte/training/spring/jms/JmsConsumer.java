package org.fischermatte.training.spring.jms;

import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.adapter.MessageListenerAdapter;

import javax.jms.ConnectionFactory;

import static org.fischermatte.training.spring.jms.JmsConfig.EMAIL_QUEUE_DESTINATION;
import static org.fischermatte.training.spring.jms.JmsConfig.TEXT_QUEUE_DESTINATION;

public class JmsConsumer {

    @JmsListener(destination = TEXT_QUEUE_DESTINATION)
    public void onReceiveMessage1(String text) {
        System.out.println("Received <" + text + ">");
    }

    @JmsListener(destination = EMAIL_QUEUE_DESTINATION)
    public void onReceiveMessage2(Email email) {
        System.out.println("Received <" + email.getText() + ">");
    }

    @Bean
    public MessageListenerAdapter messageListenerAdapter() {
        MessageListenerAdapter messageListenerAdapter = new MessageListenerAdapter();
        messageListenerAdapter.setDelegate(new JmsConsumerPojo());
        messageListenerAdapter.setDefaultListenerMethod("onReceiveMessage");
        return messageListenerAdapter;
    }

    @Bean
    public DefaultMessageListenerContainer jmsContainer(ConnectionFactory connectionFactory, MessageListenerAdapter messageListenerAdapter) {
        DefaultMessageListenerContainer jmsContainer = new DefaultMessageListenerContainer();
        jmsContainer.setDestinationName(TEXT_QUEUE_DESTINATION);
        jmsContainer.setConnectionFactory(connectionFactory);
        jmsContainer.setMessageListener(messageListenerAdapter);
        return jmsContainer;
    }

    private class JmsConsumerPojo {
        public void onReceiveMessage3(String text) {
            System.out.println("Received <" + text + ">");
        }
    }

}
