package com.epam.edp.foo.config;

import org.springframework.cloud.context.restart.RestartEndpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Pavlo_Yemelianov
 */
@Configuration
public class AppConfig {

    @Bean
    RestartEndpoint restartEndpoint() {
        return new RestartEndpoint();
    }
}
