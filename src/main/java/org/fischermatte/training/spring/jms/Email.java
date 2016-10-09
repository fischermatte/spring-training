package org.fischermatte.training.spring.jms;

import java.io.Serializable;

public class Email implements Serializable {

    private final String subject;
    private final String text;

    public Email(String subject, String text) {
        this.subject = subject;
        this.text = text;
    }

    public String getSubject() {
        return subject;
    }

    public String getText() {
        return text;
    }
}
