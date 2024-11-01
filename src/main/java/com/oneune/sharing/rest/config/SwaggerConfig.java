package com.oneune.sharing.rest.config;

import com.oneune.sharing.rest.aop.annotation.ConfigurationBeansInfo;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.log4j.Log4j2;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationBeansInfo
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Log4j2
public class SwaggerConfig implements Config {

    ServerProperties serverProperties;

    @Value("${spring.application.name}")
    @NonFinal String appName;

    @Value("${spring.application.version}")
    @NonFinal String appVersion;

    @Override
    public void init() {
        String swaggerUrl = new URIBuilder()
                .setScheme(serverProperties.getSsl().isEnabled() ? "https" : "http")
                .setHost("localhost")                                                   // refactor hardcode
                .setPort(serverProperties.getPort())
                .setPath("/swagger-ui/index.html")
                .toString();
        log.info("See swagger API description on {}", swaggerUrl);
    }

    private License getLicense() {
        return new License()
                .name("MIT License")
                .url("https://choosealicense.com/licenses/mit/");
    }

    @Bean
    public OpenAPI openApi() {
        Info info = new Info()
                .title("Cервис по бизнес-процессам «%s-rest»".formatted(appName))
                .version(appVersion)
                .license(getLicense());
        return new OpenAPI().info(info);
    }
}
