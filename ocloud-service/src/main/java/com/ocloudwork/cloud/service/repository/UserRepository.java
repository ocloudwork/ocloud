package com.ocloudwork.cloud.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ocloudwork.cloud.service.entity.User;

/**
 * @author zhouli
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
