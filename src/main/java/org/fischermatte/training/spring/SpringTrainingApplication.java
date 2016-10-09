package org.fischermatte.training.spring;

import org.fischermatte.training.spring.jdbc.JdbcService;
import org.fischermatte.training.spring.jms.JmsProducer;
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

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringTrainingApplication.class, args);
		SpringTrainingApplication application = context.getBean(SpringTrainingApplication.class);
		application.doSomeStuff();
	}

	public void doSomeStuff(){
		jdbcService.doSomeJdbc();
		jmsProducer.doSomeJms();
	}
}
