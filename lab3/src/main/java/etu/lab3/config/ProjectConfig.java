package etu.lab3.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "etu.lab3.proxy")
public class ProjectConfig {
}
