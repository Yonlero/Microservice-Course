package com.abraaofaher.hrworker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.Collections;

@EnableEurekaClient
@SpringBootApplication
public class HrWorkerApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(HrWorkerApplication.class);
        app.setDefaultProperties(Collections
                .singletonMap("server.port", "8001"));
        app.run(args);
    }

}
