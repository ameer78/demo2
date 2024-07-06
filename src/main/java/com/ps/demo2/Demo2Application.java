package com.ps.demo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ps.demo2.repository.UserRepository;
import com.ps.demo2.repository.RoleRepository;

@SpringBootApplication()
@EnableJpaRepositories(basePackages = "com.ps.demo2.repository")
public class Demo2Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo2Application.class, args);
	}

}
