package com.abraaofaher.hrpayroll.model.services;

import com.abraaofaher.hrpayroll.model.entities.Payment;
import com.abraaofaher.hrpayroll.model.entities.Worker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Value("${hr-worker.host}")
    private String host;

    private RestTemplate restTemplate;

    public PaymentService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Payment getPayment(long workId, int days){
        Map<String, String> uriVariable = new HashMap<>();
        uriVariable.put("id",String.valueOf(workId));

        Worker worker = restTemplate.getForObject(host + "/workers/{id}", Worker.class, uriVariable);
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}