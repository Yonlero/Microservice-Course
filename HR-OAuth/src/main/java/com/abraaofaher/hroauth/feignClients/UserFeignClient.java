package com.abraaofaher.hroauth.feignClients;

import com.abraaofaher.hroauth.model.entities.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "HR-User", path = "/users")
public interface UserFeignClient {
    @GetMapping(value = "/search") //Parametro não obrigatorio com ?
    ResponseEntity<User> findByEmail(@RequestParam String email);//RequestParam e para parametros não obrigatoriso na URL
}