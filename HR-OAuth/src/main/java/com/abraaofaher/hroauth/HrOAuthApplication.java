package com.abraaofaher.hroauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class HrOAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrOAuthApplication.class, args);
    }

}
