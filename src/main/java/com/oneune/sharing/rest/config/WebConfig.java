package com.oneune.sharing.rest.config;

import com.oneune.sharing.rest.aop.annotation.ConfigurationBeansInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ConfigurationBeansInfo
public class WebConfig implements Config {

    public static final String API_ROOT_URL = "api/";

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
