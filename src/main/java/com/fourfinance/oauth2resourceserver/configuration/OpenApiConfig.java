package com.fourfinance.oauth2resourceserver.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.OAuthFlow;
import io.swagger.v3.oas.annotations.security.OAuthFlows;
import io.swagger.v3.oas.annotations.security.OAuthScope;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import lombok.experimental.UtilityClass;

@OpenAPIDefinition(info = @Info(title = "Cars Service", description = "Cars Service", version = "1.0"))
@SecurityScheme(name = OpenApiConfig.BEARER_KEY, type = SecuritySchemeType.OAUTH2,
    flows = @OAuthFlows(
        authorizationCode = @OAuthFlow(
            authorizationUrl = "${springdoc.OAuthFlow.authorizationUrl}",
            tokenUrl = "${springdoc.OAuthFlow.tokenUrl}",
            refreshUrl = "${springdoc.OAuthFlow.tokenUrl}",
            scopes = {
                @OAuthScope(name = "openid", description = "openid"),
            }
        )
    )
)
@UtilityClass
public class OpenApiConfig {

    public static final String BEARER_KEY = "bearer_key";

}
