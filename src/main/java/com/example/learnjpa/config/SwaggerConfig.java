package com.example.learnjpa.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SwaggerConfig implements WebMvcConfigurer {

  private static final String REDIRECT_URL = "/swagger-ui.html";

  @Value("${spring.mvc.servlet.path}")
  private String baseUrl;

  @Override
  public void addViewControllers(final ViewControllerRegistry registry) {
    registry.addRedirectViewController("/", baseUrl.concat(REDIRECT_URL));
    registry.addRedirectViewController("/swagger-ui", baseUrl.concat(REDIRECT_URL));
    registry.addRedirectViewController("/api", baseUrl.concat(REDIRECT_URL));
  }

  @Bean
  public OpenAPI apiDocConfig() {
    return new OpenAPI()
        .info(new Info().title("Spring Boot 3 JPA").description("").version("0.0.1"));
  }
}
