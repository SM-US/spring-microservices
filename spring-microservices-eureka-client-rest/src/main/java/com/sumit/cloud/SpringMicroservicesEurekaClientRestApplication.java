package com.sumit.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class SpringMicroservicesEurekaClientRestApplication {

	@Autowired
	private EurekaClient client;
	
	@RequestMapping("/serviceinfo")
	public String getServiceInfo() {
		InstanceInfo instance = client.getNextServerFromEureka("eureka-client", false);
		return instance.getHomePageUrl();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringMicroservicesEurekaClientRestApplication.class, args);
	}
}
