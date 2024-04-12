package com.sivalabs.modernboot;

import org.springframework.boot.SpringApplication;

public class TestApplication {

	public static void main(String[] args) {
		// While running the application locally using Testcontainers support,
		// we don't need to enable the Spring Docker Compose support.
		// If not disabled, it will try to start the containers using Docker Compose as well.
		// Usually you either use Testcontainers or Spring Docker Compose support, not both.
		System.setProperty("spring.docker.compose.enabled", "false");

		SpringApplication
				.from(Application::main)
				.with(ContainersConfig.class)
				.run(args);
	}

}
