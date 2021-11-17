package com.abraaofaher.hroauth.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class AppConfig {
    Logger logger = LoggerFactory.getLogger(AppConfig.class);
    @Value("${jwt.secret}")
    private String jwtSecret;
    //Aqui eu declaro quem vai ficar responsavel por encriptar e desencriptar a senha
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    //Aqui eu defino as palavras secretas e tb digo que ele vai ficar responsavel pelos segredos
    @Bean
    public JwtAccessTokenConverter accessTokenConverter (){
        JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
        tokenConverter.setSigningKey(jwtSecret);
        logger.info("OLHA A BOLINHA : " + jwtSecret);
        return tokenConverter;
    }
    //Esse cara aqui é responsavel por entender oque o cara de cima mandou (ler o token)
    @Bean
    public JwtTokenStore tokenStore (){
        return new JwtTokenStore(accessTokenConverter());
    }
}