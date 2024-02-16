package etu.rs.lab2.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "etu.rs.lab2.proxy")
public class ProjectConfig {
}
