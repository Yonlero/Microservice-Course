package com.abraaofaher.hruser.model.repositories;

import com.abraaofaher.hruser.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail (String email);
}