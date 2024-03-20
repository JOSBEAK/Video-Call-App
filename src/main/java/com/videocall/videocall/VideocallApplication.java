package com.videocall.videocall;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class VideocallApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideocallApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			PersonService service
	) {
		return args -> {
			service.register(Person.builder()
					.username("Ali")
					.email("ali@mail.com")
					.password("aaa")
					.build());

			service.register(Person.builder()
					.username("John")
					.email("john@mail.com")
					.password("aaa")
					.build());

			service.register(Person.builder()
					.username("Anny")
					.email("anna@mail.com")
					.password("aaa")
					.build());
		};
	}

}