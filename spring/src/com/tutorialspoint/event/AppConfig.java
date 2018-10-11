package com.tutorialspoint.event;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
//    @Bean
//    public CustomEvent customEvent() {
//        return new CustomEvent(this);
//    }

    @Bean
    public CustomEventPublisher customEventPublisher() {
        return new CustomEventPublisher();
    }

    @Bean
    public CustomEventHandler customEventHandler() {
        return new CustomEventHandler();
    }
}
