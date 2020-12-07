package com.example.simplerestapis.scheduler;

import com.example.simplerestapis.NumberGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Collections;

import com.example.simplerestapis.repository.JobRepository;
import com.example.simplerestapis.models.Job;


import java.util.stream.IntStream;

@Component
public class ScheduledTasks {
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private NumberGenerator numberGenerator;

    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    @Scheduled(fixedRate = 10000)
    @Async
    public void scheduleTaskWithFixedRate() throws InterruptedException {
        List<Job> jobs = jobRepository.findByStatus("IN_PROGRESS");
//        for (Job model : jobs)
//        {
//
//            logger.info("UDATING  - {}", model.getUUID() );
//           String list = numberGenerator.generate(model.getSTEP(),model.getGOAL());
//            logger.info("GENRETAED  - {}", list);
//           jobRepository.updateStatus(model.getId(),"SUCCESS", list);
//
//
//        }
        if (!jobs.isEmpty()){
            String list = numberGenerator.generate(jobs.get(0).getSTEP(),jobs.get(0).getGOAL());
            jobRepository.updateStatus(jobs.get(0).getId(),"SUCCESS", list);
        }

        logger.info("Fixed Rate Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()) );
    }
}