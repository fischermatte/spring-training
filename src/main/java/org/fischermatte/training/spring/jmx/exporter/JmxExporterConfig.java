package org.fischermatte.training.spring.jmx.exporter;

import org.springframework.context.annotation.Bean;
import org.springframework.jmx.export.MBeanExporter;
import org.springframework.jmx.support.MBeanServerFactoryBean;

import java.util.HashMap;
import java.util.Map;

//@Configuration
public class JmxExporterConfig {

    @Bean
    public JmxBean jmxBean (){
        return new JmxBean().setValue("hallo jmx via exporter");
    }

    @Bean
    public MBeanServerFactoryBean mbeanServer() {
        MBeanServerFactoryBean server = new MBeanServerFactoryBean();
        server.setLocateExistingServerIfPossible(true);
        return server;
    }

    @Bean
    public MBeanExporter mBeanExporter(MBeanServerFactoryBean mbeanServer, JmxBean jmxBean){
        MBeanExporter exporter = new MBeanExporter();
        Map<String, Object> beans = new HashMap<>();
        beans.put("org.fischermatte.exporter:name=georgsJmxBean", jmxBean);
        exporter.setBeans(beans);
        exporter.setAutodetect(true);
        exporter.setServer(mbeanServer.getObject());
        return exporter;
    }
}
