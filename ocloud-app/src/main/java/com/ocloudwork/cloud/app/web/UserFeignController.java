package com.ocloudwork.cloud.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ocloudwork.cloud.app.entity.User;
import com.ocloudwork.cloud.app.feign.UserFeignClient;

@RequestMapping("/feign")
@RestController
public class UserFeignController {
  @Autowired
  private UserFeignClient userFeignClient;

  @GetMapping("/users/{id}")
  public User findById(@PathVariable Long id) {
    return this.userFeignClient.findById(id);
  }
}
