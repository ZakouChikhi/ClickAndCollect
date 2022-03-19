package com.orleans.univ.microservices.servicecatalogue.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    String jwkSetUri = "http://localhost:8000/auth/realms/clickCollect/protocol/openid-connect/certs";

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers(HttpMethod.POST).hasRole("RESTORER")
                .antMatchers(HttpMethod.DELETE).hasRole("RESTORER")
                .antMatchers(HttpMethod.PUT).hasRole("RESTORER")
                .antMatchers(HttpMethod.GET).hasRole("USER")
                .and()
                .oauth2ResourceServer().jwt(
                        jwt -> jwt.jwtAuthenticationConverter(jwtConverter())
                );
    }

    private Converter jwtConverter(){
        JwtAuthenticationConverter converter =  new  JwtAuthenticationConverter();
        converter.setJwtGrantedAuthoritiesConverter(new KeycloakRealmRoleConverter());
        return converter;
    }

    @Bean
    JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder.withJwkSetUri(this.jwkSetUri).build();
    }
}

