package com.example.sd20204.buoi13;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalTime;

@Component
public class DemoScheduling {
    long startTime = System.nanoTime();

//    @Scheduled(fixedRate = 1000)
//    public void demoSchedule() {
//        System.out.println(Instant.now().toString());
//    }

    @Scheduled(fixedRate = 1000) // Crontab: 0 0 * * * *
    public void demoSchedule() {
        LocalTime currentTime = LocalTime.now(); // Get the current time
        int hour = currentTime.getHour(); // Extract the hour component
        System.out.println("Gio hien tai la: " + hour);

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;

        long total_seconds = totalTime / 1_000_000_000;
        long hours = total_seconds / 3600;
        long remaining_seconds_after_hours = total_seconds % 3600;
        long minutes = remaining_seconds_after_hours / 60;
        long seconds = remaining_seconds_after_hours % 60;
        String formatted_time = String.format("%02d:%02d:%02d", hours, minutes, seconds);

        System.out.println("Chuong trinh da chay duoc: " + formatted_time);
    }
}
