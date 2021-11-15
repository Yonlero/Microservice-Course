package com.abraaofaher.hrpayroll.model.services;

import com.abraaofaher.hrpayroll.feignClient.WorkerFeignClient;
import com.abraaofaher.hrpayroll.model.entities.Payment;
import com.abraaofaher.hrpayroll.model.entities.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private final WorkerFeignClient workerFeignClient;

    public PaymentService(WorkerFeignClient workerFeignClient) {
        this.workerFeignClient = workerFeignClient;
    }

    public Payment getPayment(long workId, int days) {
        Worker worker = workerFeignClient.findById(workId).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}