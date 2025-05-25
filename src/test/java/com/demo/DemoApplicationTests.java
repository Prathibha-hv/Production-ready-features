package com.demo;

import com.demo.entity.User;
import com.demo.service.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private JwtService jwtService;

	@Test
	void contextLoads() {
		User user=new User(4L,"prathi@gmail.com","1234");
		String token=jwtService.generateToken(user);
		System.out.println(token);
		Long id=jwtService.getUserIdFromToken(token);
		System.out.println(id);
	}

}
