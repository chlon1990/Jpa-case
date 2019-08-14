package com.example.demo.service.impl;

import javax.annotation.Resource;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo.service.FileMqService;

@Service
public class FileMqServiceImpl implements FileMqService {
	private static Logger logger = LoggerFactory.getLogger(FileMqServiceImpl.class);
	@Resource(name = "rabbitTemplate")
	private RabbitTemplate rabbitTemplate;

	@Value("${mq.exchange.name}")
	private String exchange;

	@Value("${mq.routekey}")
	private String routeKey;

	@Override
	public void sendParseRequest(Object message) throws Exception {
		try {
			rabbitTemplate.convertAndSend(exchange, routeKey, message);
		} catch (Exception e) {
			logger.error("FileMqServiceImpl.sendParseRequest", ExceptionUtils.getMessage(e));
		}
	}

}
