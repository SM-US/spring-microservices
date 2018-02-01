package com.sumit.cloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringMicroservicesSimpleService2Application {

	
	@Value("${server.port}")
	public String port;
	
	
	@RequestMapping("/execute")
	public String execute() {
		return "Response from the server with port " + this.port;
	}
	
	@RequestMapping("/")
	public String status() {
		return "Service is up and running.";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringMicroservicesSimpleService2Application.class, args);
	}
}
