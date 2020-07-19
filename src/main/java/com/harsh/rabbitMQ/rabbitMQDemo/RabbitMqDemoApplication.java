package com.harsh.rabbitMQ.rabbitMQDemo;

import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitMqDemoApplication implements CommandLineRunner{

	@Autowired
	private RabbitMessagingTemplate rabbitMessagingTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(RabbitMqDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		SimpleMessage simpleMessage = new SimpleMessage();
		simpleMessage.setName("Harsh Shah");
		simpleMessage.setDescription("RabbitMQ demo");
		rabbitMessagingTemplate.convertAndSend("TestExchange", "testRouting", simpleMessage);
		
	}
	
	

}
