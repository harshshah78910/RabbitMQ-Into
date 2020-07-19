package com.harsh.rabbitMQ.rabbitMQDemo.queueCreation;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQQueueConfiguration {
	
	@Bean
	Queue beanExampleForQueueCreation()
	{
		return new Queue("Bean Example", true);
	}
	
	@Bean
	Queue builderExForQueueCreation()
	{
		return QueueBuilder.durable("Builder Ex").autoDelete().exclusive().build();
	}
	
	
	

}
