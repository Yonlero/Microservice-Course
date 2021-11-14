package com.abraaofaher.hrworker.model.repositories;

import com.abraaofaher.hrworker.model.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {
}