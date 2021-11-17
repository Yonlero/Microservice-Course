package com.abraaofaher.hrapigatewayzuul.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class AppConfig {
    //Aqui eu defino as palavras secretas e tb digo que ele vai ficar responsavel pelos segredos
    @Bean
    public JwtAccessTokenConverter accessTokenConverter (){
        JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
        tokenConverter.setSigningKey("UnaBolinaDeGofe");
        return tokenConverter;
    }
    //Esse cara aqui é responsavel por entender oque o cara de cima mandou (ler o token)
    @Bean
    public JwtTokenStore tokenStore (){
        return new JwtTokenStore(accessTokenConverter());
    }
}