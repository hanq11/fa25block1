package com.example.tutorsof3022;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DemoSchedule {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(cron = "0 0 * * * ?")
    public void reportTime() {
        System.out.println("Thoi gian hien tai la: " + dateFormat.format(new Date()));
    }
}
