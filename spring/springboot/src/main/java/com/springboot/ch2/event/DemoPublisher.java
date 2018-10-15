package com.springboot.ch2.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

//public class DemoPublisher implements ApplicationEventPublisherAware {
//    ApplicationEventPublisher publisher;
//    public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
//        this.publisher = publisher;
//    }
//}

@Component
public class DemoPublisher {
    @Autowired
    ApplicationContext context;

    public void publish(String msg) {
        context.publishEvent(new DemoEvent(this, msg));
    }
}
