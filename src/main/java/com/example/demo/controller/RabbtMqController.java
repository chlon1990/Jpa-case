package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.FileMqService;

@RestController
public class RabbtMqController {
	@Autowired
	private FileMqService fileMqService;
	
	@RequestMapping("/mq")
	public void testSend(String mqMessage) {
		try {
			fileMqService.sendParseRequest(mqMessage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
