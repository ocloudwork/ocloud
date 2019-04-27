package com.ocloudwork.cloud.service.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ocloudwork.cloud.service.entity.User;
import com.ocloudwork.cloud.service.repository.UserRepository;

/**
 * @author zhouli
 */
@RequestMapping("/users")
@RestController
public class UserController {
  @Autowired
  private UserRepository userRepository;

  @GetMapping("/{id}")
  public Optional<User> findById(@PathVariable Long id) {
    return this.userRepository.findById(id);
  }
}
