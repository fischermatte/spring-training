package org.fischermatte.training.spring;

import org.fischermatte.training.spring.factorybean.WelcomeText;
import org.fischermatte.training.spring.jdbc.JdbcService;
import org.fischermatte.training.spring.jms.JmsProducer;
import org.fischermatte.training.spring.mvc.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringTrainingApplication {

    @Autowired
    private JdbcService jdbcService;

    @Autowired
    private JmsProducer jmsProducer;
    @Autowired
    private RestClient restClient;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringTrainingApplication.class, args);
        SpringTrainingApplication application = context.getBean(SpringTrainingApplication.class);
        // application.doSomeStuff();

        // get the factory bean of jmsProducer
        WelcomeText welcomeText = context.getBean(WelcomeText.class);
    }

    public void doSomeStuff() {
        jdbcService.doSomeJdbc();
        jmsProducer.doSomeJms();
        restClient.doSomeRest();
    }
}
