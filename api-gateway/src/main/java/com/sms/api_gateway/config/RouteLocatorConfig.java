package com.sms.api_gateway.config;

import com.sms.api_gateway.filter.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteLocatorConfig {

    @Autowired
    private JwtAuthenticationFilter jwtFilter;

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("users", route -> route.path("/users/**")
                        .and().method("POST")
                        .uri("http://localhost:8080"))
                .route("users", route -> route.path("/users/**")
                        .filters(f -> f.filter(jwtFilter))
                        .uri("http://localhost:8080"))
                .route("auth", route -> route.path("/auth/**")
                        .uri("http://localhost:8070"))
                .build();
    }
}
