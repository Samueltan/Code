package com.springboot.ch3.scheduled;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan("com.springboot.ch3.scheduled")
@EnableScheduling
public class TaskSchedulerConfig {
}
