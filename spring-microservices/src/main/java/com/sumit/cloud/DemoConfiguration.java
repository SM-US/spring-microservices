package com.sumit.cloud;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoConfiguration {

	@Bean
	public List<String> cities(){
		return Arrays.asList("Jersey City", "Princeton", "Hoboken", "East Rutherford");
	}
	
}
