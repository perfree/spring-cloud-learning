package com.perfree;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker //开启断路器,或者可以直接使用@SpringCloudApplication代替这三个注解,@SpringCloudApplication = @EnableDiscoveryClient +@SpringBootApplication＋@EnableCircuitBreaker
public class SpringCloudRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudRibbonApplication.class, args);
	}
	
	//注入RestTemplate
	@Bean
	@LoadBalanced//开启负载均衡
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
