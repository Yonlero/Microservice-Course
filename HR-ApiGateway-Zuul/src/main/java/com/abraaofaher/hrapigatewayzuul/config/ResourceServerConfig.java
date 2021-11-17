package com.abraaofaher.hrapigatewayzuul.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    private JwtTokenStore tokenStore;

    //Definindo as rotas para cada tipo de perfil
    private static final String[] PUBLIC = { "/HR-OAuth/oauth/token" };
    private static final String[] OPERATOR = { "/HR-Worker/**" };
    private static final String[] ADMIN = { "/HR-Payroll/**", "/HR-User/**" };

    public ResourceServerConfig(JwtTokenStore tokenStore) {
        this.tokenStore = tokenStore;
    }

    //Agora o projeto sabe LER um token
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(tokenStore);
    }
    //Esse cara aqui configura as autorizações
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(PUBLIC).permitAll()
                .antMatchers(HttpMethod.GET, OPERATOR).hasAnyRole("OPERATOR", "ADMIN")
                .antMatchers(ADMIN).hasRole("ADMIN")
                .anyRequest().authenticated();
    }
}