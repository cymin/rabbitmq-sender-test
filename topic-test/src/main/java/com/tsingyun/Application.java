package com.tsingyun;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class Application {

    private final Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
    }

	@Scheduled(fixedDelay = 5000L)
    public void send() {
        String msg = "I am message one ";
        this.rabbitTemplate.convertAndSend("dataAcquisitionExchange", "data.acquisition.101", msg);

        msg = "I am message two ";
        this.rabbitTemplate.convertAndSend("dataAcquisitionExchange", "data.acquisition.102", msg);

        msg = "I am message three";
        this.rabbitTemplate.convertAndSend("dataAcquisitionExchange", "data.acquisition.103", msg);

    }

    @Autowired
    private RabbitTemplate rabbitTemplate;
}
