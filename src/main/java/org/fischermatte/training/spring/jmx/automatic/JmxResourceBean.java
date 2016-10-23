package org.fischermatte.training.spring.jmx.automatic;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource(
        objectName = "org.fischermatte.automatic:type=MyJmxShit,name=MyAwesomeJmxBean",
        description = "crazy jmx shit")
public class JmxResourceBean {
    private String value;

    @ManagedAttribute(description = "Value")
    public JmxResourceBean setValue(String value) {
        this.value = value;
        return this;
    }

    @ManagedAttribute(description = "Value")
    public String getValue() {
        return value;
    }
}
