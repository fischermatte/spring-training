package org.fischermatte.training.spring.jms;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsMessagingTemplate;

import javax.jms.Queue;
import java.util.Arrays;

@Configuration
@EnableJms
public class JmsConfiguration {
    static final String TEXT_QUEUE_DESTINATION = "text-destination";
    static final String EMAIL_QUEUE_DESTINATION = "email-destination";

    @Bean
    public JmsConsumer jmsConsumer() {
        return new JmsConsumer();
    }

    @Bean
    public JmsProducer jmsProducer(JmsMessagingTemplate jmsMessagingTemplate, Queue textQueue, Queue emailQueue) {
        return new JmsProducer(jmsMessagingTemplate, textQueue, emailQueue);
    }

    @Bean
    public Queue textQueue() {
        return new ActiveMQQueue(TEXT_QUEUE_DESTINATION);
    }

    @Bean
    public Queue emailQueue() {
        return new ActiveMQQueue(EMAIL_QUEUE_DESTINATION);
    }

//    @Bean
//    public MessageConverter emailMessageConverter(){
//        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
//        converter.setTargetType(MessageType.TEXT);
//        converter.setTypeIdPropertyName("_type");
//        return converter;
//    }
}
