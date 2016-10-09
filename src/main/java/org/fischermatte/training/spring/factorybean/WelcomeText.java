package org.fischermatte.training.spring.factorybean;

/**
 * Created by ludewigg on 09.10.16.
 */
public class WelcomeText {
    private String text;

    public WelcomeText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
