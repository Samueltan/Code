package com.springboot.ch2.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(EventConfig.class);

        DemoPublisherAware publisher = context.getBean(DemoPublisherAware.class);
        publisher.publish("hello event via ApplicationEventPublisherAware");

        DemoPublisher publisher2 = context.getBean(DemoPublisher.class);
        publisher2.publish("this is my message ApplicationContext");

        context.close();
    }
}
