package com.example.simplerestapis;

import com.example.simplerestapis.scheduler.ScheduledTasks;
import org.springframework.stereotype.Component;
import java.util.Arrays;

import java.util.stream.IntStream;
import java.util.List;
import java.util.Collections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Collections;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.Random;

@Component
public class NumberGenerator {

    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public String generate(Integer step, Integer goal) throws InterruptedException {
        Random rn = new Random();
        StringBuilder buff = new StringBuilder();
        String sep = "";
        while (goal >= 0) {
            System.out.println(goal);
            buff.append(sep);
            buff.append(goal);
            goal -= step;
            sep = ",";
        }
        System.out.println(buff.toString());
        try {
            Thread.sleep(rn.nextInt(10) + 1);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }

        return buff.toString();
    }

    public void intStream(Integer step, Integer goal){
        Integer n = 5;
        Integer newGoal = goal;

        do {
            newGoal = newGoal - step;
            System.out.println(newGoal);
        } while(n <= 0);
    }

}
