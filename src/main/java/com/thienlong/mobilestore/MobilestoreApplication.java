package com.thienlong.mobilestore;

import com.thienlong.mobilestore.repository.UserRepository;
import com.thienlong.mobilestore.entity.Userss;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class MobilestoreApplication {

//	@Autowired
//	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(MobilestoreApplication.class, args);
	}
//
//	@Override
//	public void run(String... args) throws Exception {
//		List<Userss> list = userRepository.findAll();
//		list.forEach(System.out::println);
//	}
}
