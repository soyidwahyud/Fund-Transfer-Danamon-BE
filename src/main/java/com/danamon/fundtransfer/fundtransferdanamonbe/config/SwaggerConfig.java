package com.danamon.fundtransfer.fundtransferdanamonbe.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl("http://localhost:8080");
        devServer.setDescription("Server URL in Development environment");

        Info info = new Info()
                .title("Tutorial Management API")
                .version("1.0")
                .description("This API exposes endpoints to manage Danamon Fund Transfer API.");

        License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

        return new OpenAPI().info(info).servers(List.of(devServer));
    }
}
