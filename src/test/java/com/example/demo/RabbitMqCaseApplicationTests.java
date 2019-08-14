package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.service.FileMqService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqCaseApplicationTests {


	@Autowired
	private FileMqService fileMqService;

	@Test
	public void contextLoads() throws Exception {
		for(int i = 1 ; i<= 20 ;i++ ) {
			fileMqService.sendParseRequest("message: " + i);
		}
	}
	

}
