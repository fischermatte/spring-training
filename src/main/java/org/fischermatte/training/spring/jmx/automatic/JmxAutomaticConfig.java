package org.fischermatte.training.spring.jmx.automatic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableMBeanExport not needed in spring boot
public class JmxAutomaticConfig {

    @Bean
    public JmxResourceBean jmxResoruceBean (){
        return new JmxResourceBean().setValue("hallo jmx via exporter");
    }

}
