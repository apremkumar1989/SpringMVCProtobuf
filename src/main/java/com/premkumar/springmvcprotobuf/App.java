package com.premkumar.springmvcprotobuf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class);
	}

	@Bean
	ProtobufHttpMessageConverter protobufHttpMessageConverter() {
		System.out.println("instantiating proto http converter====================");
		return new ProtobufHttpMessageConverter();
	}
}
