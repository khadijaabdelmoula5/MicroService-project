package tn.micro.service.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
@SpringBootApplication
//@ComponentScan({"tn.micro.service.cloud.controller", "tn.micro.service.cloud.service"})
//@EntityScan("tn.micro.service.cloud.entity")
//@EnableJpaRepositories("tn.micro.service.cloud.repository")

@EnableFeignClients("tn.micro.service.cloud.feign")
public class StudentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentServiceApplication.class, args);

    }
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:4200"); 
        config.addAllowedHeader("");
        config.addAllowedMethod("");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }



}