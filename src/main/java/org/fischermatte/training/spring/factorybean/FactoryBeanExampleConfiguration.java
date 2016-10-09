package org.fischermatte.training.spring.factorybean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FactoryBeanExampleConfiguration {

    @Bean
    public WelcomeTextFactoryBean welcomeTextFactoryBean() {
        return new WelcomeTextFactoryBean();
    }

    @Bean
    public WelcomeText welcomeTextMrMueller(WelcomeTextFactoryBean welcomeTextFactoryBean) throws Exception {
        welcomeTextFactoryBean.setName("Mueller");
        return welcomeTextFactoryBean.getObject();
    }

    @Bean
    public WelcomeText welcomeTextMrBrecht(WelcomeTextFactoryBean welcomeTextFactoryBean) throws Exception {
        welcomeTextFactoryBean.setName("Brecht");
        return welcomeTextFactoryBean.getObject();
    }
}
