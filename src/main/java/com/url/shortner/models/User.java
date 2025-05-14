package com.url.shortner.models;

import jakarta.persistence.*;
        import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String username;
    private String password;
    private String role = "ROLE_USER";

    @Configuration
    public static class WebConfig implements WebMvcConfigurer {

        @Value("${frontend.url}")
        String frontEndUrl;

        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**")
                    .allowedOrigins(frontEndUrl)
                    .allowedMethods("GET","POST","PUT","DELETE","OPTIONS")
                    .allowedHeaders("*")
                    .allowCredentials(true);
        }
    }
}
