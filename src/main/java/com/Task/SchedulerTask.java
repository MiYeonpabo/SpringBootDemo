package com.Task;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerTask {

    @Scheduled(cron = "*/6 * * * * ?")
    public void task() {
        int count = 1;
        System.out.println("this is scheduler task runing  " + (count++));
    }
}
