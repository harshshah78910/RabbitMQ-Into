package com.harsh.rabbitMQ.rabbitMQDemo.listener;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

	private static final String MY_QUEUE = "MyQueue";

	@Bean
	Queue myQueue() // This will create new Queue in RabbitMQ
	{
		return new Queue(MY_QUEUE);
	}

	@Bean
	ConnectionFactory connectionFactory() {
		CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory("localhost");
		cachingConnectionFactory.setUsername("guest");
		cachingConnectionFactory.setPassword("guest");
		return cachingConnectionFactory;
	}

	@Bean
	MessageListenerContainer messageListenerContainer() {
		SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
		simpleMessageListenerContainer.setConnectionFactory(connectionFactory());
		simpleMessageListenerContainer.setQueues(myQueue());
		simpleMessageListenerContainer.setMessageListener(new RabbitMQMessageListener());
		return simpleMessageListenerContainer;
	}

	@Bean
	Exchange exchangeExampleForBinding() {
		return new TopicExchange("MyExchange");
	}

	@Bean
	Binding bindingMyQueue_MyExchange() {
		return BindingBuilder.bind(myQueue()).to(exchangeExampleForBinding()).with("myRoute").noargs();
	}
}
