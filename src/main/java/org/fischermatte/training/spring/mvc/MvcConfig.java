package org.fischermatte.training.spring.mvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig {

    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("index");
                registry.addViewController("/index.html").setViewName("index");
                registry.addViewController("/login.html").setViewName("login");
            }
        };
    }

//    @Bean
//    public UrlFilenameViewController urlViewController() {
//        return new UrlFilenameViewController();
//    }
//
//    @Bean
//    public SimpleUrlHandlerMapping getUrlHandlerMapping() {
//        SimpleUrlHandlerMapping handlerMapping = new SimpleUrlHandlerMapping();
//        Properties mappings = new Properties();
//        mappings.put("/**/*.html", "urlViewController");
//        handlerMapping.setMappings(mappings);
//        return handlerMapping;
//    }
}
