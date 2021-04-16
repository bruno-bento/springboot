package com.example.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.course.entities.Order;
import com.example.course.entities.User;
import com.example.course.repositories.OrderRepository;
import com.example.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Alex", "Alex@gmail.com", "11111111111", "123456");
		User u2 = new User(null, "Ralph", "Ralph@gmail.com", "11111111111", "123456");
		
		Order o1 = new Order(null, Instant.parse("2021-06-20T19:53:07Z"), u1);
		Order o2 = new Order(null, Instant.parse("2021-07-21T03:42:10Z"), u2);
		Order o3 = new Order(null, Instant.parse("2021-07-22T15:21:22Z"), u1);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
}
