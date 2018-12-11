package com.perfree.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class HelloController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod="errMsg")//指定服务报错时,执行的方法,该方法参数需要与原方法参数一致
	@RequestMapping("/")
	public String hello() {
		return restTemplate.getForEntity("http://MY-CLIENT/hello", String.class).getBody();
	}
	
	public String errMsg() {
		return "出错了";
	}
}
