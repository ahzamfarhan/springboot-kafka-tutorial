package net.javaguides.springboot.kafka;

import net.javaguides.springboot.payloads.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {


	@Value("${spring.kafka.json.topic.name}")
	private String jsonTopicName;
	private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

	private KafkaTemplate<String, String> kafkaTemplate;

	public JsonKafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {

		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage(User data) {

		Message<User> message = MessageBuilder
				.withPayload(data)
				.setHeader(KafkaHeaders.TOPIC, jsonTopicName)
				.build();		

		kafkaTemplate.send(message);

		LOGGER.info(String.format("Message: %s", data));
	}
}