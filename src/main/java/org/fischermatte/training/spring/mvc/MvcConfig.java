package org.fischermatte.training.spring.mvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.UrlFilenameViewController;

import java.util.Properties;

@Configuration
public class MvcConfig {

    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("index");
            }
        };
    }

    @Bean
    public UrlFilenameViewController urlFilenameViewController() {
        return new UrlFilenameViewController();
    }

    @Bean
    public SimpleUrlHandlerMapping urlFilenameHandlerMapping() {
        SimpleUrlHandlerMapping handlerMapping = new SimpleUrlHandlerMapping();
        Properties mappings = new Properties();
        mappings.put("/**/*.html", "urlFilenameViewController");
        handlerMapping.setOrder(Integer.MAX_VALUE - 2);
        handlerMapping.setMappings(mappings);
        return handlerMapping;
    }
}
