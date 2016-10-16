package org.fischermatte.training.spring.jms;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.adapter.MessageListenerAdapter;

import javax.jms.ConnectionFactory;

import static org.fischermatte.training.spring.jms.JmsConfiguration.TEXT_QUEUE_DESTINATION;

@Configuration
public class JmsConsumerWithAdapter {


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
        public void onReceiveMessage(String text) {
            System.out.println("Received <" + text + ">");
        }
    }
}
