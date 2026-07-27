package com.cruz.medicaments_api.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "jwt")
public record JwtProperties (
        String secret,
        Long expiration
){
}
