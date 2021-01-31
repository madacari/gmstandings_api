package com.gmstandingssim.gmstandingsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class GmStandingsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GmStandingsApiApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/tournament-data")
						.allowedOrigins("http://localhost:3000",
								"https://youthful-goldberg-afc5cf.netlify.app");
			}
		};
	}


}
