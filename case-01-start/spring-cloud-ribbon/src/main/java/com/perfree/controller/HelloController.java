package com.perfree.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/")
	public String hello() {
		return restTemplate.getForEntity("http://127.0.0.1:8882/hello", String.class).getBody()+" Spring Cloud";
	}
}
