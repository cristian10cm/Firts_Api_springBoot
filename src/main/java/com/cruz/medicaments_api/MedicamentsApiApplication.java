package com.cruz.medicaments_api;

import com.cruz.medicaments_api.config.JwtProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(JwtProperties.class)
public class MedicamentsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicamentsApiApplication.class, args);
	}

}
