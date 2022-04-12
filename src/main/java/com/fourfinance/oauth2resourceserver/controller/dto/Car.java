package com.fourfinance.oauth2resourceserver.controller.dto;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class Car {

    Long id;

    String manufacturer;

}
