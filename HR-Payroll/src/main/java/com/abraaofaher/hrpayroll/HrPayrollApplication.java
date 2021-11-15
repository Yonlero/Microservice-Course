package com.abraaofaher.hrpayroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.Collections;

@RibbonClient(name = "HR-Worker")
@EnableFeignClients
@SpringBootApplication
public class HrPayrollApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(HrPayrollApplication.class);
        app.setDefaultProperties(Collections
                .singletonMap("server.port", "8101"));
        app.run(args);
    }

}
