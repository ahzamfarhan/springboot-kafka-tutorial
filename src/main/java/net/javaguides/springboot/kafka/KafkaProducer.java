package net.javaguides.springboot.kafka;

import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;

@Service 
public class KafkaProducer {
	private static final Logger LOGGER =  LoggerFactory.getLogger(KafkaProducer.class);

	//org.springframework.kafka.core.KafkaTemplate;
	private KafkaTemplate<String, String> kafkaTemplate;

	public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage(String message) {
		
		LOGGER.info(String.format("Message: %s is sent", message));


		//kafkaTemplate.send(textTopic, message);
		kafkaTemplate.send("javaguides", message);

	}
}
