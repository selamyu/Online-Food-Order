package com.job.comapany.job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class UserFeedbackApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserFeedbackApplication.class, args);
    }
}