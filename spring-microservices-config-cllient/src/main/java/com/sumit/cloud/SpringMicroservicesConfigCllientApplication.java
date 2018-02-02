package com.sumit.cloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RefreshScope
public class SpringMicroservicesConfigCllientApplication {

	@Value("${message}")
	private String message;
	
	@RequestMapping("/message")
	public String getMessage() {
		return this.message;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringMicroservicesConfigCllientApplication.class, args);
	}
}
