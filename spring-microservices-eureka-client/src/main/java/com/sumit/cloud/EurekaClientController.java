package com.sumit.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class EurekaClientController {

	@Autowired
	public RestTemplate restTemplate;
	
	@RequestMapping("/execute")
	public String getEurekaRestClientResoponse() {
		return restTemplate.getForObject("http://EUREKA-CLIENT-REST/serviceinfo", String.class);
	}
}
