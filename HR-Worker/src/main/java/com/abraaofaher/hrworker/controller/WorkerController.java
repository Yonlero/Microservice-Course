package com.abraaofaher.hrworker.controller;

import com.abraaofaher.hrworker.model.entities.Worker;
import com.abraaofaher.hrworker.model.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/workers")
public class WorkerController {
    @Autowired
    private WorkerRepository workerRepository;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        List<Worker> workerList = workerRepository.findAll();
        return ResponseEntity.ok(workerList);
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<Worker> findById(@PathVariable Long id) {
        Optional<Worker> worker = workerRepository.findById(id);
        return ResponseEntity.ok(worker.get());
    }
}