package com.taxi.spring;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.reactive.config.EnableWebFlux;
@Configuration
@EnableConfigurationProperties
@EnableAutoConfiguration
@EntityScan(basePackages = {
        "com.taxi.entities"})
@EnableJpaRepositories(basePackages = {"com.taxi.repository"})
@ComponentScan(basePackages = {"com.taxi.**"})
@EnableWebFlux
public class ApplicationConfig {
}
