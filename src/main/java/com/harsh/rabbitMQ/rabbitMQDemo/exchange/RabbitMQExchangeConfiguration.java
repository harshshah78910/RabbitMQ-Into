package com.harsh.rabbitMQ.rabbitMQDemo.exchange;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQExchangeConfiguration {

	@Bean
	Exchange exchangeExample()
	{
		return new TopicExchange("topic Exchange Example");
	}
	
	@Bean
	Exchange exchangeBuilderExample()
	{
		return ExchangeBuilder.directExchange("direct Exchange Ex").autoDelete().build();
	}
	
}
