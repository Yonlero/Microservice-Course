package com.abraaofaher.hrworker.controller;

import com.abraaofaher.hrworker.model.entities.Worker;
import com.abraaofaher.hrworker.model.repositories.WorkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/workers")
public class WorkerController {

    private static Logger logger = LoggerFactory.getLogger(WorkerController.class);
    private final Environment env;
    private final WorkerRepository workerRepository;

    @Value("${test.config}")
    private String testConfig;

    public WorkerController(WorkerRepository workerRepository, Environment env) {
        this.workerRepository = workerRepository;
        this.env = env;
    }

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        List<Worker> workerList = workerRepository.findAll();
        return ResponseEntity.ok(workerList);
    }

    @GetMapping(value = "/configs")
    public ResponseEntity<List<Worker>> getConfig() {
        logger.info("CONFIG : " + testConfig);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<Worker> findById(@PathVariable Long id) {
        logger.info("PORT = " + env.getProperty("local.server.port"));
        Optional<Worker> worker = workerRepository.findById(id);
        return ResponseEntity.ok(worker.get());
    }
}