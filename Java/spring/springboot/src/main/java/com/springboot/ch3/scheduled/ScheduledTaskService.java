package com.springboot.ch3.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
public class ScheduledTaskService {
    private static final SimpleDateFormat dateFormat =
            new SimpleDateFormat("yyyy-MM-dd hh:mm:ssa");
    private static final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    @Scheduled(fixedRate = 800)
    public void reportCurrentTime() {
        System.out.println("Current time is: " + dateFormat.format(new Date()));
        System.out.println("Current time is: " + LocalDateTime.now().format(formatter));
    }

    @Scheduled(cron = "0 28 11 ? * *")
    public void fixTimeExecution() {
        System.out.println("Run at " + dateFormat.format(new Date()));
    }
}
