package com.tsingyun;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
    }

	@Scheduled(fixedDelay = 3000L)
    public void send() {
        rabbitTemplate.convertAndSend("rabbitmq.test", "test message");
    }

    @Autowired
    private RabbitTemplate rabbitTemplate;
}
