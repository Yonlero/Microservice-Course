package com.abraaofaher.hroauth.model.services;

import com.abraaofaher.hroauth.feignClients.UserFeignClient;
import com.abraaofaher.hroauth.model.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class UserService implements Serializable {

    Logger logger = LoggerFactory.getLogger(UserService.class);
    private UserFeignClient userFeignClient;

    public UserService(UserFeignClient userFeignClient) {
        this.userFeignClient = userFeignClient;
    }

    public User findByEmail(String email){
        User user = userFeignClient.findByEmail(email).getBody();
        if( user == null){
            logger.error("Email not found" + email);
            throw new IllegalArgumentException("Email not found");
        }
        logger.info("email found " + email);
        return user;
    }
}