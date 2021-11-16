package com.abraaofaher.hruser.controller;

import com.abraaofaher.hruser.model.entities.User;
import com.abraaofaher.hruser.model.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable long id){
        User user = userRepository.findById(id).get();
        return ResponseEntity.ok(user);
    }

    @GetMapping(value = "/search") //Parametro não obrigatorio com ?
    public ResponseEntity<User> findByEmail(@RequestParam String email){ //RequestParam e para parametros não obrigatoriso na URL
        User user = userRepository.findByEmail(email);
        return ResponseEntity.ok(user);
    }
}