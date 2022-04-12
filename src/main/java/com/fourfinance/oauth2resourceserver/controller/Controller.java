package com.fourfinance.oauth2resourceserver.controller;

import static com.fourfinance.oauth2resourceserver.configuration.OpenApiConfig.BEARER_KEY;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fourfinance.oauth2resourceserver.controller.dto.Car;
import com.fourfinance.oauth2resourceserver.controller.dto.Customers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
public class Controller {

    @PreAuthorize("hasRole('cars:read')")
    @SecurityRequirement(name = BEARER_KEY)
    @GetMapping(value = "/api/cars", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Car> cars(@AuthenticationPrincipal Jwt principal) {
        return List.of(
            Car.builder()
                .id(1L)
                .manufacturer("BMW")
                .build(),
            Car.builder()
                .id(2L)
                .manufacturer("Tesla")
                .build()
        );
    }

    // Add 'customers:read' role to access this endpoint
    @PreAuthorize("hasRole('customers:read')")
    @SecurityRequirement(name = BEARER_KEY)
    @GetMapping(value = "/api/customers", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Customers> personalContacts() {
        return List.of(
            Customers.builder()
                .name("Mister Smith")
                .phoneNumber("227064564")
                .build(),
            Customers.builder()
                .name("John Doe")
                .phoneNumber("436545756")
                .build()
        );
    }

}
