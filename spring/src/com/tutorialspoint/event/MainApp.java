package com.tutorialspoint.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CustomEventPublisher publisher = context.getBean(CustomEventPublisher.class);

        publisher.publish();
        publisher.publish();
    }
}
