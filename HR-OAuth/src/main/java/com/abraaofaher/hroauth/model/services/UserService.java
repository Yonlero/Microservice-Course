package com.abraaofaher.hroauth.model.services;

import com.abraaofaher.hroauth.feignClients.UserFeignClient;
import com.abraaofaher.hroauth.model.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class UserService implements UserDetailsService {
    @Value("${jwt.secret}")
    private String jwtSecret;
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
        logger.info("OLHA A BOLINHA PASSANDO : " + jwtSecret);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userFeignClient.findByEmail(s).getBody();
        if( user == null){
            logger.error("Email not found" + s);
            throw new UsernameNotFoundException("Email not found");
        }
        logger.info("email found " + s);
        return user;
    }
}