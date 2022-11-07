package com.fabflix;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.fabflix.*" })
public class BackEndApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(BackEndApplication.class, args);

	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public StrongPasswordEncryptor encryptor() {
		return new StrongPasswordEncryptor();
	}
}
