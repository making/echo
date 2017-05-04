package com.example;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

@SpringBootApplication
public class EchoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EchoApplication.class, args);
	}

	@Bean
	RouterFunction<ServerResponse> echo() {
		return route(req -> true, req -> req.bodyToMono(String.class).flatMap(
				b -> ServerResponse.ok().contentType(MediaType.TEXT_PLAIN).syncBody(b)));
	}
}
