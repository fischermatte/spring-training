package org.fischermatte.training.spring.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class WelcomeTextFactoryBean implements FactoryBean<WelcomeText> {

    private String name = "Mustermann";

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public WelcomeText getObject() throws Exception {
        return new WelcomeText("Welcome to Spring, Mr. " + name);
    }

    @Override
    public Class<?> getObjectType() {
        return WelcomeText.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
