package com.ocloudwork.cloud.service.config;

import java.math.BigDecimal;
import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.ocloudwork.cloud.service.entity.User;
import com.ocloudwork.cloud.service.repository.UserRepository;

@Component
public class BeanConfig {
	/**
	 * 初始化用户信息 注：Spring
	 * Boot2不能像1.x一样，用spring.datasource.schema/data指定初始化SQL脚本，否则与actuator不能共存 原因详见：
	 * https://github.com/spring-projects/spring-boot/issues/13042
	 * https://github.com/spring-projects/spring-boot/issues/13539
	 *
	 * @param repository repo
	 * @return runner
	 */
	@Bean
	ApplicationRunner init(UserRepository repository) {
		return args -> {
			User user1 = new User(1L, "account1", "张三", 20, new BigDecimal(100.00));
			User user2 = new User(2L, "account2", "李四", 28, new BigDecimal(180.00));
			User user3 = new User(3L, "account3", "王五", 32, new BigDecimal(280.00));
			Stream.of(user1, user2, user3).forEach(repository::save);
		};
	}
}
