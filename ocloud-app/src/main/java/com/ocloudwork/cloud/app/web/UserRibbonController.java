package com.ocloudwork.cloud.app.web;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.ocloudwork.cloud.app.entity.User;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/ribbon")
@RestController
@Slf4j
public class UserRibbonController {
	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "findByIdFallback")
	@GetMapping("/users/{id}")
	public User findById(@PathVariable Long id) {
		// 这里用到了RestTemplate的占位符能力
		User user = this.restTemplate.getForObject("http://ocloud-service/users/{id}", User.class, id);
		return user;
	}

	public User findByIdFallback(Long id, Throwable throwable) {
		log.error("进入回退方法", throwable);
		return new User(id, "默认用户", "默认用户", 0, new BigDecimal(1));
	}

}
