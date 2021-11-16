package com.abraaofaher.hroauth.controller;

import com.abraaofaher.hroauth.model.entities.User;
import com.abraaofaher.hroauth.model.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping(value = "/search")
    public ResponseEntity<User> findByEmail (@RequestParam String email){
        User user = service.findByEmail(email);
        return ResponseEntity.ok(user);
    }
}