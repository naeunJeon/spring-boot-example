package com.example.demo2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo2ApplicationTests {
	@Autowired
	private ApplicationContext context;

	@Test
	public void contextLoads() {
		boolean result = context.containsBeanDefinition("postController");
		assertThat(result).isTrue();
	}


}

