package com.liverpool.exam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfigCompomex {

	@Bean
	WebClient copomexWebClient() {
		return WebClient.builder()
				.baseUrl("https://api.copomex.com")
				.build();
	}
}
