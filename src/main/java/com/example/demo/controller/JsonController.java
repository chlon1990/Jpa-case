package com.example.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.SpringContextConfig;

@RestController
public class JsonController {

	@Autowired
	SpringContextConfig springContextConfig;

	@GetMapping("/findJsonDate")
	public Object findJsonDate() {

		Map<String, Object> map = new HashMap<>();

		map.put("v1", 123);
		map.put("v2", "haha");
		map.put("v3", new Date());

		return map;
	}
	
	
	@GetMapping("/changeObjectMapper")
	public void changeObjectMapper() {
		ApplicationContext applicationContext = SpringContextConfig.getApplicationContext();
		MappingJackson2HttpMessageConverter bean = 
				applicationContext.getBean(MappingJackson2HttpMessageConverter.class);
		bean.getObjectMapper().setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
	}

}
