package com.example.demo.rabbitmq;

import com.rabbitmq.client.ConnectionFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;

@Configuration
//@ComponentScan(basePackages = { "com.lianggzone.rabbitmq" })
@PropertySource(value = { "classpath:application.yml" })
public class RabbitMQConfig {

	@Autowired
	private Environment env;

	@Bean
	public ConnectionFactory connectionFactory() throws Exception {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.setHost(env.getProperty("mq.host").trim());
		connectionFactory.setPort(Integer.parseInt(env.getProperty("mq.port").trim()));
		connectionFactory.setVirtualHost(env.getProperty("mq.vhost").trim());
		connectionFactory.setUsername(env.getProperty("mq.username").trim());
		connectionFactory.setPassword(env.getProperty("mq.password").trim());
		return connectionFactory;
	}

	@Bean
	public CachingConnectionFactory cachingConnectionFactory() throws Exception {
		return new CachingConnectionFactory(connectionFactory());
	}

	@Bean
	public RabbitTemplate rabbitTemplate() throws Exception {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(cachingConnectionFactory());
		rabbitTemplate.setChannelTransacted(true);
		return rabbitTemplate;
	}

	@Bean
	public AmqpAdmin amqpAdmin() throws Exception {
		return new RabbitAdmin(cachingConnectionFactory());
	}

	@Bean
	Queue queue() {
		String name = env.getProperty("mq.queue.name").trim();

		boolean durable = StringUtils.isNotBlank(env.getProperty("mq.queue.durable").trim())
				? Boolean.valueOf(env.getProperty("mq.queue.durable").trim())
				: true;

		boolean exclusive = StringUtils.isNotBlank(env.getProperty("mq.queue.exclusive").trim())
				? Boolean.valueOf(env.getProperty("mq.queue.exclusive").trim())
				: false;

		boolean autoDelete = StringUtils.isNotBlank(env.getProperty("mq.queue.autoDelete").trim())
				? Boolean.valueOf(env.getProperty("mq.queue.autoDelete").trim())
				: false;

		return new Queue(name, durable, exclusive, autoDelete);
	}

	@Bean
	DirectExchange exchange() {
		String name = env.getProperty("mq.exchange.name").trim();

		boolean durable = StringUtils.isNotBlank(env.getProperty("mq.exchange.durable").trim())
				? Boolean.valueOf(env.getProperty("mq.exchange.durable").trim())
				: true;

		boolean autoDelete = StringUtils.isNotBlank(env.getProperty("mq.exchange.autoDelete").trim())
				? Boolean.valueOf(env.getProperty("mq.exchange.autoDelete").trim())
				: false;

		return new DirectExchange(name, durable, autoDelete);
	}

	@Bean
	public SimpleMessageListenerContainer listenerContainer(
			@Qualifier("parseFileMessageListenerAdapter") ParseFileMessageListenerAdapter parseFileMessageListenerAdapter)
			throws Exception {
		String queueName = env.getProperty("mq.queue.name").trim();

		SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer(cachingConnectionFactory());
		simpleMessageListenerContainer.setQueueNames(queueName);
		simpleMessageListenerContainer.setMessageListener(parseFileMessageListenerAdapter);
		simpleMessageListenerContainer.setAcknowledgeMode(AcknowledgeMode.MANUAL);
		simpleMessageListenerContainer.setPrefetchCount(1);
		return simpleMessageListenerContainer;
	}

	@Bean
	Binding binding() {
		String routekey = env.getProperty("mq.routekey").trim();
		return BindingBuilder.bind(queue()).to(exchange()).with(routekey);
	}
}
