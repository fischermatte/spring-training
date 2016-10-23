package org.fischermatte.training.spring.jmx.exporter;

public class JmxBean {
    private String value;

    public JmxBean setValue(String value) {
        this.value = value;
        return this;
    }

    public String getValue() {
        return value;
    }
}
