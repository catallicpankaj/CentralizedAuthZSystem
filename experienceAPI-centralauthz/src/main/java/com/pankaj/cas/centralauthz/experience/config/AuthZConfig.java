package com.pankaj.cas.centralauthz.experience.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AuthZConfig {
	
	@Bean
	WebClient webClient() {
	  return WebClient.builder().build();
	}

}
