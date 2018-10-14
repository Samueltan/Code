package com.tutorialspoint.event.custom;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Service
public class CustomEventHandler implements ApplicationListener<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent customEvent) {
        System.out.println(customEvent.toString());
    }
}
