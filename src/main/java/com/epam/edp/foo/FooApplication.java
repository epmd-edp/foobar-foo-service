package com.epam.edp.foo;

import io.fabric8.spring.cloud.kubernetes.archaius.ArchaiusConfigMapSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
@ArchaiusConfigMapSource(name = "foo-dynamic")
public class FooApplication {

    public static void main(String[] args) {
        SpringApplication.run(FooApplication.class, args);
    }
}
