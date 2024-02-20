package etu.lab2Main.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "etu.lab2Main.proxy")
public class ProjectConfig {
}
